package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.WeekDao;
import ua.kiev.ukma.tg.model.Week;
import ua.kiev.ukma.tg.service.GroupService;

@Repository
public class WeekDaoImpl implements WeekDao {

	@Autowired
	private GroupService groupService;

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Week> getAll() {
		return currentSession().createQuery("FROM Week").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Week> getGroupWeeks(Integer groupId) {
		String semester = groupService.getById(groupId).getSubject().getSemester().getTitle();
		if ("2Ä".equals(semester))
			return currentSession().createQuery("FROM Week w WHERE w.id <7").getResultList();
		else
			return currentSession().createQuery("FROM Week").getResultList();
	}

}