package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Rhythm;

public interface RhythmDao extends Dao<Rhythm, Integer> {
	
	List<Rhythm> getByGroup(Integer groupId);
	void addAll(Integer groupId);
	
}