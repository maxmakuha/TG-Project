package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Subject;

public interface SubjectDao extends Dao<Subject, Integer> {
	
	List<Subject> getByTeacher(String email);
	
}