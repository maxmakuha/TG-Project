package ua.kiev.ukma.tg.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.SubjectDao;
import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.model.Subject;
import ua.kiev.ukma.tg.service.GroupService;

@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private GroupService groupService;

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Subject getById(Integer id) {
		return (Subject) currentSession().get(Subject.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getByTeacher(String email) {
		List<Group> groups = groupService.getTeacherGroups(email);
		List<Subject> subjects = currentSession().createQuery("FROM Subject ORDER BY year.title DESC").getResultList();
		List<Subject> teacherSubjects = new ArrayList<Subject>();
		for (Group g : groups)
			for (Subject s : subjects)
				if (s.getId() == g.getSubject().getId() && !teacherSubjects.contains(s))
					teacherSubjects.add(s);
		return teacherSubjects;
	}

	@Override
	public void add(Subject subject) {
		currentSession().save(subject);
	}

	@Override
	public void update(Subject subject) {
		currentSession().update(subject);
	}

	@Override
	public void delete(Integer id) {
		Subject subject = (Subject) currentSession().load(Subject.class, id);
		if (null != subject) {
			currentSession().delete(subject);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getAll() {
		return currentSession().createQuery("FROM Subject ORDER BY year.title DESC").getResultList();
	}
}