package com.app.jpa.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.jpa.service.CrudService;

import java.util.List;

public abstract class RestCrudController<Entity> extends BaseRestCrudController<Entity> {

	public RestCrudController(CrudService<Entity> service) {
		super(service);
	}

	@GetMapping("")
	public List<Entity> list() {
		return service.findAll();
	}

	@Override
	@GetMapping("{id}")
	public ResponseEntity<Entity> show(@PathVariable long id) {
		return super.show(id);
	}

	@Override
	@PostMapping("")
	public ResponseEntity<String> add(@RequestBody Entity entity) throws Exception {
		return super.add(entity);
	}

	@Override
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		return super.delete(id);
	}

}
