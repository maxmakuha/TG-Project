package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.PeriodDao;
import ua.kiev.ukma.tg.model.Period;

@Repository
public class PeriodDaoImpl implements PeriodDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Period getById(Integer id) {
		return (Period) currentSession().get(Period.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Period> getByTimetable(Integer timetableId) {
		TypedQuery<Period> query = currentSession().createQuery("FROM Period p WHERE p.timetable.id = :timetable_id");
		query.setParameter("timetable_id", timetableId);
		return query.getResultList();
	}

	@Override
	public void add(Period period) {
		currentSession().save(period);
	}

	@Override
	public void update(Period period) {
		currentSession().update(period);
	}

	@Override
	public void delete(Integer id) {
		Period period = (Period) currentSession().load(Period.class, id);
		if (null != period) {
			currentSession().delete(period);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Period> getAll() {
		return currentSession().createQuery("FROM Period").getResultList();
	}
}