package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Period;

public interface PeriodDao extends Dao<Period, Integer> {

	List<Period> getByTimetable(Integer timetableId);

}