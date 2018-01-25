package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.AudienceDao;
import ua.kiev.ukma.tg.model.Audience;
import ua.kiev.ukma.tg.service.AudienceService;

@Service
@Transactional(readOnly = true)
public class AudienceServiceImpl implements AudienceService {

	@Autowired
	private AudienceDao audienceDao;

	@Override
	public Audience getById(Integer id) {
		return audienceDao.getById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Audience audience) {
		audienceDao.add(audience);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Audience audience) {
		audienceDao.update(audience);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		audienceDao.delete(id);
	}

	@Override
	public List<Audience> getAll() {
		return audienceDao.getAll();
	}
}