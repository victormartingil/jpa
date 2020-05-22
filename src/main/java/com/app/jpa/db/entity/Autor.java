package com.app.jpa.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	@ManyToMany (mappedBy="autores")
	private Set<Libro> libros;
	
	public Autor() {
	}
	
	public Autor(long id) {
		this(id, null, new HashSet<>());
	}
	
	public Autor (String nombre) {
		this(0, nombre, new HashSet<>());
	}
	
	public Autor(long id, String nombre, Set<Libro> libros) {
		this.id = id;
		this.nombre = nombre;
		this.libros = libros;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	
	public void addLibro (Libro libro) {
		if (libros.contains(libro))
			return;
		libros.add(libro);
		libro.getAutores().add(this);
	}
	
	public void removeLibro (Libro libro) {
		if (!libros.contains(libro))
			return;
		libros.remove(libro);
		libro.getAutores().remove(this);
	}
	
}
