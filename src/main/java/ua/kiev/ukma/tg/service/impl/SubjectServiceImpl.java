package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.SubjectDao;
import ua.kiev.ukma.tg.model.Subject;
import ua.kiev.ukma.tg.service.SubjectService;

@Service
@Transactional(readOnly = true)
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;

	@Override
	public Subject getById(Integer id) {
		return subjectDao.getById(id);
	}
	
	@Override
	public List<Subject> getByTeacher(String email) {
		return subjectDao.getByTeacher(email);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Subject subject) {
		subjectDao.add(subject);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Subject subject) {
		subjectDao.update(subject);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		subjectDao.delete(id);
	}

	@Override
	public List<Subject> getAll() {
		return subjectDao.getAll();
	}
}