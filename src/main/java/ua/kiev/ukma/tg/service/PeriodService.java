package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Period;

public interface PeriodService extends Service<Period, Integer> {
	
	List<Period> getByTimetable(Integer timetableId);
	boolean checkPeriod(Period period);
	
}