package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.RhythmDao;
import ua.kiev.ukma.tg.model.Rhythm;
import ua.kiev.ukma.tg.service.RhythmService;

@Service
@Transactional(readOnly = true)
public class RhythmServiceImpl implements RhythmService {

	@Autowired
	private RhythmDao rhythmDao;

	@Override
	public Rhythm getById(Integer id) {
		return rhythmDao.getById(id);
	}

	@Override
	public List<Rhythm> getByGroup(Integer groupId) {
		return rhythmDao.getByGroup(groupId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Rhythm rhythm) {
		rhythmDao.add(rhythm);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addAll(Integer groupId) {
		rhythmDao.addAll(groupId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Rhythm rhythm) {
		rhythmDao.update(rhythm);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		rhythmDao.delete(id);
	}

	@Override
	public List<Rhythm> getAll() {
		return rhythmDao.getAll();
	}
}