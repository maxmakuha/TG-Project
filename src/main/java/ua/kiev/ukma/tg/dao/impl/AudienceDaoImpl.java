package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.AudienceDao;
import ua.kiev.ukma.tg.model.Audience;

@Repository
public class AudienceDaoImpl implements AudienceDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Audience getById(Integer id) {
		return (Audience) currentSession().get(Audience.class, id);
	}

	@Override
	public void add(Audience audience) {
		currentSession().save(audience);
	}

	@Override
	public void update(Audience audience) {
		currentSession().update(audience);
	}

	@Override
	public void delete(Integer id) {
		Audience audience = (Audience) currentSession().load(Audience.class, id);
		if (null != audience) {
			currentSession().delete(audience);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Audience> getAll() {
		return currentSession().createQuery("FROM Audience").getResultList();
	}
}