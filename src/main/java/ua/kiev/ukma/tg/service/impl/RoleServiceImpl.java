package ua.kiev.ukma.tg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.RoleDao;
import ua.kiev.ukma.tg.model.Role;
import ua.kiev.ukma.tg.service.RoleService;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Role getRoleByTitle(String title) {
		return roleDao.getRoleByTitle(title);
	}
}