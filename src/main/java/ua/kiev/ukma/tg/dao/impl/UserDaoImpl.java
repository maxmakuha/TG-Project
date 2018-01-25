package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.UserDao;
import ua.kiev.ukma.tg.model.User;
import ua.kiev.ukma.tg.model.UserAuth;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getById(Integer id) {
		return (User) currentSession().get(User.class, id);
	}

	@Override
	public void add(User user) {
		currentSession().save(user);
	}

	@Override
	public void update(User user) {
		currentSession().update(user);
	}

	@Override
	public void delete(Integer id) {
		User user = (User) currentSession().load(User.class, id);
		if (null != user) {
			currentSession().delete(user);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return currentSession().createQuery("FROM User").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByRole(String role) {
		TypedQuery<User> query = currentSession().createQuery("FROM User WHERE role.role = :role");
		query.setParameter("role", role);
		return query.getResultList();
	}

	@Override
	public UserAuth getUserAuth(String email) {
		@SuppressWarnings("unchecked")
		TypedQuery<UserAuth> query = currentSession().createQuery("FROM UserAuth WHERE email = :email");
		query.setParameter("email", email);
		List<UserAuth> user = query.getResultList();
		return user.isEmpty() ? null : user.get(0);
	}
}