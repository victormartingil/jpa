package com.app.jpa.dto;

import java.util.HashSet;
import java.util.Set;

//@AutorDtoConstraint(groups = {Create.class, Edit.class})
//@AutorDtoDeleteConstrait(groups = {Delete.class})
public class AutorDto {

	private long id;
	
	private String nombre;
	
	private Set<LibroDto> libros;
	
	public AutorDto() {
	}
	
	public AutorDto(long id) {
		this(id, null, new HashSet<>());
	}
	
	public AutorDto(String nombre) {
		this(0, nombre, new HashSet<>());
	}
	
	public AutorDto(long id, String nombre, Set<LibroDto> libros) {
		this.id = id;
		this.nombre= nombre;
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

	public Set<LibroDto> getLibros() {
		return libros;
	}

	public void setLibros(Set<LibroDto> libros) {
		this.libros = libros;
	}
	
	public void addLibro (LibroDto libro) {
		if (libros.contains(libro))
			return;
		libros.add(libro);
		libro.getAutores().add(this);
	}
	
	public void removeLibro (LibroDto libro) {
		if (!libros.contains(libro))
			return;
		libros.remove(libro);
		libro.getAutores().remove(this);
	}
	
}
