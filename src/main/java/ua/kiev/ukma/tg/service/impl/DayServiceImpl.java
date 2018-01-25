package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.DayDao;
import ua.kiev.ukma.tg.model.Day;
import ua.kiev.ukma.tg.service.DayService;

@Service
@Transactional(readOnly = true)
public class DayServiceImpl implements DayService {

	@Autowired
	private DayDao dayDao;
	
	@Override
	public List<Day> getAll() {
		return dayDao.getAll();
	}
}