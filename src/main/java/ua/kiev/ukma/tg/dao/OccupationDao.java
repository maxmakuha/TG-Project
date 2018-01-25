package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Occupation;

public interface OccupationDao extends Dao<Occupation, Integer> {

	List<Occupation> getByAudience(Integer audienceId);

}