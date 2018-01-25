package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.LessonDao;
import ua.kiev.ukma.tg.model.Lesson;
import ua.kiev.ukma.tg.service.LessonService;

@Service
@Transactional(readOnly = true)
public class LessonServiceImpl implements LessonService {

	@Autowired
	private LessonDao lessonDao;

	@Override
	public List<Lesson> getAll() {
		return lessonDao.getAll();
	}
	
	@Override
	public List<Lesson> getAllExceptFirst() {
		List<Lesson> lessons = lessonDao.getAll();
		lessons.remove(0);
		return lessons;
	}
}