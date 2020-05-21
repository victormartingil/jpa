package com.app.jpa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.jpa.db.entity.Libro;
import com.app.jpa.service.CrudService;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController extends RestCrudController<Libro> {
	
	@Autowired
	public LibroRestController(CrudService<Libro> service) {
		super(service);
    }
		
}