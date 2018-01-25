package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.WeekDao;
import ua.kiev.ukma.tg.model.Week;
import ua.kiev.ukma.tg.service.WeekService;

@Service
@Transactional(readOnly = true)
public class WeekServiceImpl implements WeekService {

	@Autowired
	private WeekDao weekDao;
	
	@Override
	public List<Week> getAll() {
		return weekDao.getAll();
	}

	@Override
	public List<Week> getGroupWeeks(Integer groupId) {
		return weekDao.getGroupWeeks(groupId);
	}
}