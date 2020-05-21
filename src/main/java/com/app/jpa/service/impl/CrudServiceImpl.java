package com.app.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.jpa.service.CrudService;

public abstract class CrudServiceImpl<Entity, Repository extends CrudRepository<Entity, Long>> implements CrudService<Entity> {

	protected Repository repository;

	public CrudServiceImpl(Repository repository) {
		this.repository = repository;
	}

	@Override
	public List<Entity> findAll() {
		List<Entity> list = new ArrayList<>();
    	list = (List<Entity>) repository.findAll();
    	return list;
	}

	@Override
	public Optional<Entity> findById(long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void create(Entity entity) {
		entity = repository.save(entity);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
