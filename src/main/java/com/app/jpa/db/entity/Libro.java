package com.app.jpa.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	
	@ManyToMany
	@JoinTable(name = "join_autor_libro",
			   joinColumns = @JoinColumn(name = "libro_id"),
			   inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private Set<Autor> autores;
	
	public Libro() {
	}
	
	public Libro(long id) {
		this(id, null, new HashSet<>());
	}
	
	public Libro (String titulo, Set<Autor> autores) {
		this(0, titulo, autores);
	}
	
	public Libro(long id, String titulo, Set<Autor> autores) {
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

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public void addAutor (Autor autor) {
		if (autores.contains(autor))
			return;
		autores.add(autor);
		autor.getLibros().add(this);
	}
	
	public void removeAutor (Autor autor) {
		if (!autores.contains(autor))
			return;
		autores.remove(autor);
		autor.getLibros().remove(this);
	}
}
