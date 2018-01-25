package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.PeriodDao;
import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.model.Period;
import ua.kiev.ukma.tg.service.GroupService;
import ua.kiev.ukma.tg.service.PeriodService;

@Service
@Transactional(readOnly = true)
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	private GroupService groupService;

	@Autowired
	private PeriodDao periodDao;

	@Override
	public Period getById(Integer id) {
		return periodDao.getById(id);
	}

	@Override
	public List<Period> getByTimetable(Integer timetableId) {
		return periodDao.getByTimetable(timetableId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Period period) {
		periodDao.add(period);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Period period) {
		periodDao.update(period);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		periodDao.delete(id);
	}

	@Override
	public List<Period> getAll() {
		return periodDao.getAll();
	}

	@Override
	public boolean checkPeriod(Period period) {
		boolean valid = true;
		List<Period> periods = getAll();
		Group group = groupService.getById(period.getGroup().getId());
		for (Period selectedPeriod : periods) {
			if (selectedPeriod.getAudience().getId() == period.getAudience().getId()
					&& selectedPeriod.getLesson().getId() == period.getLesson().getId()
					&& selectedPeriod.getMonth().equals(period.getMonth())
					&& selectedPeriod.getDaytime().equals(period.getDaytime())) {
				valid = false;
			} else if (selectedPeriod.getGroup().getTeacher().getName().equals(group.getTeacher().getName())
					&& selectedPeriod.getLesson().getId() == period.getLesson().getId()
					&& selectedPeriod.getMonth().equals(period.getMonth())
					&& selectedPeriod.getDaytime().equals(period.getDaytime())) {
				valid = false;
			}
		}
		return valid;
	}
}