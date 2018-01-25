package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Occupation;

public interface OccupationService extends Service<Occupation, Integer> {
	
	List<Occupation> getByAudience(Integer audienceId);
	
}