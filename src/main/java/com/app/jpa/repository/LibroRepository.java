package com.app.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.jpa.entity.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long>{

}
