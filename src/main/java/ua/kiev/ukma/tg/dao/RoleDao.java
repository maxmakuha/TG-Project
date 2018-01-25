package ua.kiev.ukma.tg.dao;

import ua.kiev.ukma.tg.model.Role;

public interface RoleDao {

	Role getRoleByTitle(String title);
	
}