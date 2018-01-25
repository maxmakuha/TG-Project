package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Week;

public interface WeekDao {

	List<Week> getAll();
	List<Week> getGroupWeeks(Integer groupId);
	
}