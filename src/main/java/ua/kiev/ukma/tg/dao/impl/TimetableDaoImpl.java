package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.TimetableDao;
import ua.kiev.ukma.tg.model.Timetable;

@Repository
public class TimetableDaoImpl implements TimetableDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Timetable getById(Integer id) {
		return (Timetable) currentSession().get(Timetable.class, id);
	}

	@Override
	public void add(Timetable timetable) {
		currentSession().save(timetable);
	}

	@Override
	public void update(Timetable timetable) {
		currentSession().update(timetable);
	}

	@Override
	public void delete(Integer id) {
		Timetable timetable = (Timetable) currentSession().load(Timetable.class, id);
		if (null != timetable) {
			currentSession().delete(timetable);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timetable> getAll() {
		return currentSession().createQuery("FROM Timetable ORDER BY year.title DESC").getResultList();
	}
}