package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.AbsenceDao;
import ua.kiev.ukma.tg.model.Absence;
import ua.kiev.ukma.tg.service.UserService;

@Repository
public class AbsenceDaoImpl implements AbsenceDao {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Absence getById(Integer id) {
		return (Absence) currentSession().get(Absence.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Absence> getByTeacher(String email) {
		TypedQuery<Absence> query = currentSession().createQuery("FROM Absence a WHERE a.teacher.id = :teacher_id");
		query.setParameter("teacher_id", userService.getUserAuth(email).getId());
		return query.getResultList();
	}

	@Override
	public void add(Absence absence) {
		currentSession().save(absence);
	}

	@Override
	public void update(Absence absence) {
		currentSession().update(absence);
	}

	@Override
	public void delete(Integer id) {
		Absence absence = (Absence) currentSession().load(Absence.class, id);
		if (null != absence) {
			currentSession().delete(absence);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Absence> getAll() {
		return currentSession().createQuery("FROM Absence").getResultList();
	}
}