package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.RoleDao;
import ua.kiev.ukma.tg.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role getRoleByTitle(String title) {
		@SuppressWarnings("unchecked")
		TypedQuery<Role> query = currentSession().createQuery("FROM Role WHERE role.role = :title");
		query.setParameter("title", title);
		List<Role> role = query.getResultList();
		return role.isEmpty() ? null : role.get(0);
	}
}