package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.GroupTypeDao;
import ua.kiev.ukma.tg.model.GroupType;

@Repository
public class GroupTypeDaoImpl implements GroupTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupType> getAll() {
		return currentSession().createQuery("FROM GroupType").getResultList();
	}
}