package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.DayDao;
import ua.kiev.ukma.tg.model.Day;

@Repository
public class DayDaoImpl implements DayDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Day> getAll() {
		return currentSession().createQuery("FROM Day").getResultList();
	}
}