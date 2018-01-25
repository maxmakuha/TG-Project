package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.TimetableDao;
import ua.kiev.ukma.tg.model.Timetable;
import ua.kiev.ukma.tg.service.TimetableService;

@Service
@Transactional(readOnly = true)
public class TimetableServiceImpl implements TimetableService {

	@Autowired
	private TimetableDao timetableDao;

	@Override
	public Timetable getById(Integer id) {
		return timetableDao.getById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Timetable timetable) {
		timetableDao.add(timetable);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Timetable timetable) {
		timetableDao.update(timetable);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		timetableDao.delete(id);
	}

	@Override
	public List<Timetable> getAll() {
		return timetableDao.getAll();
	}
}