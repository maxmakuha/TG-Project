package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Week;

public interface WeekService {

	List<Week> getAll();
	List<Week> getGroupWeeks(Integer groupId);
	
}