package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.OccupationDao;
import ua.kiev.ukma.tg.model.Occupation;
import ua.kiev.ukma.tg.service.OccupationService;

@Service
@Transactional(readOnly = true)
public class OccupationServiceImpl implements OccupationService {

	@Autowired
	private OccupationDao occupationDao;

	@Override
	public Occupation getById(Integer id) {
		return occupationDao.getById(id);
	}
	
	@Override
	public List<Occupation> getByAudience(Integer audienceId) {
		return occupationDao.getByAudience(audienceId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Occupation occupation) {
		occupationDao.add(occupation);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Occupation occupation) {
		occupationDao.update(occupation);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		occupationDao.delete(id);
	}

	@Override
	public List<Occupation> getAll() {
		return occupationDao.getAll();
	}
}