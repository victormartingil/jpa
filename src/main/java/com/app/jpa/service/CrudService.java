package com.app.jpa.service;

import java.util.List;
import java.util.Optional;

public interface CrudService <Entity>{
	
	public List<Entity> findAll();

	public Optional<Entity> findById(long id);

	public void create(Entity entity);

	public void delete(long id);

}
