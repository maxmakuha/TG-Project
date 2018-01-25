package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.AbsenceDao;
import ua.kiev.ukma.tg.model.Absence;
import ua.kiev.ukma.tg.service.AbsenceService;

@Service
@Transactional(readOnly = true)
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	private AbsenceDao absenceDao;

	@Override
	public Absence getById(Integer id) {
		return absenceDao.getById(id);
	}
	
	@Override
	public List<Absence> getByTeacher(String email) {
		return absenceDao.getByTeacher(email);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Absence absence) {
		absenceDao.add(absence);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Absence absence) {
		absenceDao.update(absence);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		absenceDao.delete(id);
	}

	@Override
	public List<Absence> getAll() {
		return absenceDao.getAll();
	}
}