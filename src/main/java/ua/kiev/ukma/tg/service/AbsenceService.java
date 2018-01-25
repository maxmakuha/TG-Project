package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Absence;

public interface AbsenceService extends Service<Absence, Integer> {
	
	List<Absence> getByTeacher(String email);
	
}