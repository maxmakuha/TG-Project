package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.LessonDao;
import ua.kiev.ukma.tg.model.Lesson;

@Repository
public class LessonDaoImpl implements LessonDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lesson> getAll() {
		return currentSession().createQuery("FROM Lesson").getResultList();
	}
}