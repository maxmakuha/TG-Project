package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Subject;

public interface SubjectService extends Service<Subject, Integer> {
	
	List<Subject> getByTeacher(String email);
	
}