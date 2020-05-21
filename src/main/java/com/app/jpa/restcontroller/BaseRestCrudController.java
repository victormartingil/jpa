package com.app.jpa.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.jpa.service.CrudService;

public abstract class BaseRestCrudController<Entity> {

	protected final CrudService<Entity> service;

	public BaseRestCrudController(CrudService<Entity> service) {
		this.service = service;
	}

	public ResponseEntity<String> add(@RequestBody Entity entity) throws Exception {
		try {
		service.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


	public ResponseEntity<Entity> show(@PathVariable long id) {
		return ResponseEntity.of(service.findById(id));
	}

	public ResponseEntity<String> delete(@PathVariable long id) {
		try{
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
