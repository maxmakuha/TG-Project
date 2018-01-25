package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.User;
import ua.kiev.ukma.tg.model.UserAuth;

public interface UserService extends Service<User, Integer> {

	List<User> getUsersByRole(String role);
	void addTeacher(User user);
	void addStudent(User user);
	void updateProfile(User user, String email);
	UserAuth getUserAuth(String email);
	String encodePassword(String password);

}