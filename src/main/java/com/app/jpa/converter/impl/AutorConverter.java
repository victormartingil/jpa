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
import com.app.jpa.repository.LibroRepository;

@Component
public class AutorConverter extends AbstractConverter<Autor, AutorDto>{

	private LibroRepository libroRepository;
	
	@Autowired
	public AutorConverter (LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}
	
	public Autor convertDtoToEntity(AutorDto dto) {
		
		Autor entity = new Autor (dto.getId(),
								  dto.getNombre(),
								  new HashSet<>());
		
		Optional<Libro> libroOp;
		Libro l;
		if (dto.getLibros() != null) {
			for (LibroDto libro : dto.getLibros()) {
				libroOp = libroRepository.findById(libro.getId());
				l = libroOp.isPresent()?libroOp.get():new Libro(libro.getId());
				entity.addLibro(l);
			}
		}
		
		return entity;
	}
	
	public AutorDto convertEntityToDto (Autor entity) {
		
		AutorDto dto = new AutorDto (entity.getId(),
									 entity.getNombre(),
									 new HashSet<>());
		
		if (entity.getLibros() != null) {
			for (Libro libro : entity.getLibros()) {
				dto.addLibro(new LibroDto(libro.getId()));
			}
		}
		
		return dto;
	}
	
	public Set<AutorDto> convertEntityToDto(Set<Autor> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertEntityToDto)
				  .collect(Collectors.toSet());
	}

	public Set<Autor> convertDtoToEntity(Set<AutorDto> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertDtoToEntity)
				  .collect(Collectors.toSet());
	}
	
	public void updateEntity (AutorDto dto, Autor entity) {
		entity.setNombre(dto.getNombre());
	}

}
