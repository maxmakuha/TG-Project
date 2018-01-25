package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.UserDao;
import ua.kiev.ukma.tg.model.User;
import ua.kiev.ukma.tg.model.UserAuth;
import ua.kiev.ukma.tg.service.RoleService;
import ua.kiev.ukma.tg.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleService roleService;

	@Override
	public User getById(Integer id) {
		return userDao.getById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addTeacher(User user) {
		user.setPassword(encodePassword(user.getEmail()));
		user.setRole(roleService.getRoleByTitle("TEACHER"));
		userDao.add(user);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addStudent(User user) {
		user.setPassword(encodePassword(user.getEmail()));
		user.setRole(roleService.getRoleByTitle("STUDENT"));
		userDao.add(user);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateProfile(User user, String email) {
		if (user.getPassword().equals("") || user.getPassword().equals(null))
			user.setPassword(getUserAuth(email).getPassword());
		else
			user.setPassword(encodePassword(user.getPassword()));
		userDao.update(user);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public List<User> getUsersByRole(String role) {
		return userDao.getUsersByRole(role);
	}

	@Override
	public UserAuth getUserAuth(String email) {
		return userDao.getUserAuth(email);
	}

	@Override
	public String encodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
}