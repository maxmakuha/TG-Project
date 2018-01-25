package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.User;
import ua.kiev.ukma.tg.model.UserAuth;

public interface UserDao extends Dao<User, Integer> {
	
	List<User> getUsersByRole(String role);
	UserAuth getUserAuth(String email);
	
}