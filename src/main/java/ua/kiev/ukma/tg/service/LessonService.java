package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Lesson;

public interface LessonService {

	List<Lesson> getAll();
	List<Lesson> getAllExceptFirst();
	
}