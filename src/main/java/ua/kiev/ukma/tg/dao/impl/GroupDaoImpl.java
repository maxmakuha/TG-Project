package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.GroupDao;
import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.model.Timetable;
import ua.kiev.ukma.tg.service.TimetableService;
import ua.kiev.ukma.tg.service.UserService;

@Repository
public class GroupDaoImpl implements GroupDao {

	@Autowired
	private UserService userService;
	
	@Autowired
	TimetableService timetableService;
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Group getById(Integer id) {
		return (Group) currentSession().get(Group.class, id);
	}

	@Override
	public void add(Group group) {
		currentSession().save(group);
	}

	@Override
	public void update(Group group) {
		currentSession().update(group);
	}

	@Override
	public void delete(Integer id) {
		Group group = (Group) currentSession().load(Group.class, id);
		if (null != group) {
			currentSession().delete(group);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAll() {
		return currentSession().createQuery("FROM Group").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getTimetableGroups(Integer timetableId) {
		Timetable timetable = timetableService.getById(timetableId);
		TypedQuery<Group> query = currentSession().createQuery("FROM Group g WHERE g.subject.year.id = :year_id AND g.subject.program.id = :program_id AND g.subject.course.id = :course_id AND g.subject.semester.id = :semester_id");
		query.setParameter("year_id", timetable.getYear().getId());
		query.setParameter("program_id", timetable.getProgram().getId());
		query.setParameter("course_id", timetable.getCourse().getId());
		query.setParameter("semester_id", timetable.getSemester().getId());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getSubjectGroups(Integer subject_id) {
		TypedQuery<Group> query = currentSession().createQuery("FROM Group g WHERE g.subject.id = :subject_id");
		query.setParameter("subject_id", subject_id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getTeacherGroups(String email) {
		TypedQuery<Group> query = currentSession().createQuery("FROM Group g WHERE g.teacher.id = :teacher_id");
		query.setParameter("teacher_id", userService.getUserAuth(email).getId());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getTeacherGroupsBySubject(Integer subjectId, String email) {
		TypedQuery<Group> query = currentSession().createQuery("FROM Group g WHERE g.subject.id =:subject_id AND g.teacher.id = :teacher_id");
		query.setParameter("subject_id", subjectId);
		query.setParameter("teacher_id", userService.getUserAuth(email).getId());
		return query.getResultList();
	}
}