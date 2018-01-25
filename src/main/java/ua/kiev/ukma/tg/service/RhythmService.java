package ua.kiev.ukma.tg.service;

import java.util.List;

import ua.kiev.ukma.tg.model.Rhythm;

public interface RhythmService extends Service<Rhythm, Integer> {
	
	List<Rhythm> getByGroup(Integer groupId);
	void addAll(Integer groupId);
	
}