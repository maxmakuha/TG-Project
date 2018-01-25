package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.SemesterDao;
import ua.kiev.ukma.tg.model.Semester;

@Repository
public class SemesterDaoImpl implements SemesterDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Semester> getAll() {
		return currentSession().createQuery("FROM Semester").getResultList();
	}
}