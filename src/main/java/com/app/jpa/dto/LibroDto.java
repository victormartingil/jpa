package com.app.jpa.dto;

import java.util.HashSet;
import java.util.Set;

//@LibroDtoConstraint(groups = {Create.class, Edit.class})
//@LibroDtoDeleteConstrait(groups = {Delete.class})
public class LibroDto {

	private long id;
	
	private String titulo;
	
	private Set<AutorDto> autores;
	
	public LibroDto() {
	}
	
	public LibroDto(long id) {
		this(id, null, new HashSet<>());
	}
	
	public LibroDto(String titulo, Set<AutorDto> autores) {
		this(0, titulo, autores);
	}
	
	public LibroDto(long id, String titulo, Set<AutorDto> autores) {
		this.id = id;
		this.titulo = titulo;
		this.autores = autores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<AutorDto> getAutores() {
		return autores;
	}

	public void setAutores(Set<AutorDto> autores) {
		this.autores = autores;
	}
	
}
