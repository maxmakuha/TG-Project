package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.SemesterDao;
import ua.kiev.ukma.tg.model.Semester;
import ua.kiev.ukma.tg.service.SemesterService;

@Service
@Transactional(readOnly = true)
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterDao semesterDao;
	
	@Override
	public List<Semester> getAll() {
		return semesterDao.getAll();
	}
}