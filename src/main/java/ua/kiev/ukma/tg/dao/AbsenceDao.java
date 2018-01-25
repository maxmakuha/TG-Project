package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Absence;

public interface AbsenceDao extends Dao<Absence, Integer> {
	
	List<Absence> getByTeacher(String email);
	
}