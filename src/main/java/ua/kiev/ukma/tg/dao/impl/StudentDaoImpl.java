package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.StudentDao;
import ua.kiev.ukma.tg.model.GroupStudent;
import ua.kiev.ukma.tg.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Student getById(Integer id) {
		return (Student) currentSession().get(Student.class, id);
	}

	@Override
	public void add(Student student) {
		currentSession().save(student);
	}
	
	@Override
	public void addToGroup(GroupStudent student) {
		currentSession().save(student);
	}

	@Override
	public void update(Student student) {
		currentSession().update(student);
	}

	@Override
	public void delete(Integer id) {
		Student student = (Student) currentSession().load(Student.class, id);
		if (null != student) {
			currentSession().delete(student);
		}
	}
	
	@Override
	public void deleteFromGroup(GroupStudent student) {
		if (null != student) {
			currentSession().delete(student);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		return currentSession().createQuery("FROM Student").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getOtherStudents(Integer group_id) {
		TypedQuery<Student> query = currentSession().createQuery("FROM Student s WHERE s.student_id NOT IN (SELECT gs.student.student_id FROM GroupStudent gs WHERE gs.group.id = :group_id)");
		query.setParameter("group_id", group_id);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupStudent> getStudentsByGroup(Integer id) {
		TypedQuery<GroupStudent> query = currentSession().createQuery("FROM GroupStudent WHERE group.id = :group_id");
		query.setParameter("group_id", id);
		return query.getResultList();
	}
}