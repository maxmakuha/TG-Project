package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.ProgramDao;
import ua.kiev.ukma.tg.model.Program;
import ua.kiev.ukma.tg.service.ProgramService;

@Service
@Transactional(readOnly = true)
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramDao programDao;

	@Override
	public List<Program> getAll() {
		return programDao.getAll();
	}
}