package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.AudienceTypeDao;
import ua.kiev.ukma.tg.model.AudienceType;
import ua.kiev.ukma.tg.service.AudienceTypeService;

@Service
@Transactional(readOnly = true)
public class AudienceTypeServiceImpl implements AudienceTypeService {

	@Autowired
	private AudienceTypeDao audienceTypeDao;
	
	@Override
	public List<AudienceType> getAll() {
		return audienceTypeDao.getAll();
	}
}