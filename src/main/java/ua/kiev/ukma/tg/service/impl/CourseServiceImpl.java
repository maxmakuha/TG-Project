package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.CourseDao;
import ua.kiev.ukma.tg.model.Course;
import ua.kiev.ukma.tg.service.CourseService;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> getAll() {
		return courseDao.getAll();
	}
}