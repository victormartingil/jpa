package com.app.jpa.converter.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.jpa.converter.AbstractConverter;
import com.app.jpa.db.entity.Autor;
import com.app.jpa.db.entity.Libro;
import com.app.jpa.dto.AutorDto;
import com.app.jpa.dto.LibroDto;

@Component
public class LibroConverter extends AbstractConverter<Libro, LibroDto>{

	@Autowired
	public LibroConverter () {
	}
	
	public Libro convertDtoToEntity(LibroDto dto) {
		
		Set <Autor> autores = new HashSet<>();
		if (dto.getAutores() != null) {
			for (AutorDto autor : dto.getAutores()) {
				autores.add(new Autor(autor.getId()));
			}
		}
		return new Libro (dto.getId(),
							dto.getTitulo(),
							autores);
	}
	
	public LibroDto convertEntityToDto (Libro entity) {
		
		Set<AutorDto> autores = new HashSet<>();
		if (entity.getAutores() != null) {
			for (Autor autor : entity.getAutores()) {
				autores.add(new AutorDto(autor.getId()));
			}
		}
		
		return new LibroDto (entity.getId(),
							entity.getTitulo(),
							autores);
	}
	
	public Set<LibroDto> convertEntityToDto(Set<Libro> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertEntityToDto)
				  .collect(Collectors.toSet());
	}

	public Set<Libro> convertDtoToEntity(Set<LibroDto> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertDtoToEntity)
				  .collect(Collectors.toSet());
	}
	
	public Optional<LibroDto> convertEntityToDto(Optional<Libro> optional) {
		return optional.map(this::convertEntityToDto);
	}
	
	public void updateEntity (LibroDto dto, Libro entity) {
		entity.setTitulo(dto.getTitulo());
	}

}
