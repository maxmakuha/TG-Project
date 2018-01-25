package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.YearDao;
import ua.kiev.ukma.tg.model.Year;
import ua.kiev.ukma.tg.service.YearService;

@Service
@Transactional(readOnly = true)
public class YearServiceImpl implements YearService {

	@Autowired
	private YearDao yearDao;
	
	@Override
	public List<Year> getAll() {
		return yearDao.getAll();
	}
}