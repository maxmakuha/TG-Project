package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.OccupationDao;
import ua.kiev.ukma.tg.model.Occupation;

@Repository
public class OccupationDaoImpl implements OccupationDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Occupation getById(Integer id) {
		return (Occupation) currentSession().get(Occupation.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Occupation> getByAudience(Integer audienceId) {
		TypedQuery<Occupation> query = currentSession().createQuery("FROM Occupation o WHERE o.audience.id = :audience_id");
		query.setParameter("audience_id", audienceId);
		return query.getResultList();
	}

	@Override
	public void add(Occupation occupation) {
		currentSession().save(occupation);
	}

	@Override
	public void update(Occupation occupation) {
		currentSession().update(occupation);
	}

	@Override
	public void delete(Integer id) {
		Occupation occupation = (Occupation) currentSession().load(Occupation.class, id);
		if (null != occupation) {
			currentSession().delete(occupation);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Occupation> getAll() {
		return currentSession().createQuery("FROM Occupation").getResultList();
	}
}