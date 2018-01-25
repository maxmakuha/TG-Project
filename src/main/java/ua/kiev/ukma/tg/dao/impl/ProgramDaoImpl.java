package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.ProgramDao;
import ua.kiev.ukma.tg.model.Program;

@Repository
public class ProgramDaoImpl implements ProgramDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Program> getAll() {
		return currentSession().createQuery("FROM Program").getResultList();
	}
}