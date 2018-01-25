package ua.kiev.ukma.tg.dao;

import java.util.List;

public interface Dao<Entity, Id> {
	
	Entity getById(Id id);
	
	void add(Entity entity);
	
	void update(Entity entity);
	
	void delete(Id id);
	
	List<Entity> getAll();
	
}