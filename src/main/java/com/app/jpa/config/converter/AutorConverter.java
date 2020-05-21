package com.app.jpa.config.converter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.jpa.db.entity.Autor;
import com.app.jpa.db.entity.Libro;
import com.app.jpa.dto.AutorDto;
import com.app.jpa.dto.LibroDto;

@Component
public class AutorConverter {

	@Autowired
	public AutorConverter () {
		
	}
	
	public Autor convertDtoToEntity(AutorDto dto) {
		
		Set<Libro> libros = new HashSet<>();
		if (dto.getLibros() != null) {
			for (LibroDto libro : dto.getLibros()) {
				libros.add(new Libro(libro.getId()));
			}
		}
		
		return new Autor (dto.getId(),
								dto.getNombre(),
								libros);
	}
	
	public AutorDto convertEntityToDto (Autor entity) {
		
		Set<LibroDto> libros = new HashSet<>();
		if (entity.getLibros() != null) {
			for (Libro libro : entity.getLibros()) {
				libros.add(new LibroDto(libro.getId()));
			}
		}
		
		return new AutorDto (entity.getId(),
							entity.getNombre(),
							libros);
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
	
	public void updateEntity (LibroDto dto, Libro entity) {
		entity.setTitulo(dto.getTitulo());
	}
	
}
