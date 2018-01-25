package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.AudienceTypeDao;
import ua.kiev.ukma.tg.model.AudienceType;

@Repository
public class AudienceTypeDaoImpl implements AudienceTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AudienceType> getAll() {
		return currentSession().createQuery("FROM AudienceType").getResultList();
	}
}