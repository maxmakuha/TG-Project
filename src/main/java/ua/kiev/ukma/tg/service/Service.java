package ua.kiev.ukma.tg.service;

import java.util.List;

public interface Service<Entity, Id> {

	Entity getById(Id id);

	void add(Entity entity);

	void update(Entity entity);

	void delete(Id id);
	
	List<Entity> getAll();

}