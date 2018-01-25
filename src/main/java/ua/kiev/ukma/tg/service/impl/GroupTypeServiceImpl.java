package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.GroupTypeDao;
import ua.kiev.ukma.tg.model.GroupType;
import ua.kiev.ukma.tg.service.GroupTypeService;

@Service
@Transactional(readOnly = true)
public class GroupTypeServiceImpl implements GroupTypeService {

	@Autowired
	private GroupTypeDao groupTypeDao;
	
	@Override
	public List<GroupType> getAll() {
		return groupTypeDao.getAll();
	}
}