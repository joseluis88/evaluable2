package com.midominio.evaluable2.app.service;

import com.midominio.evaluable2.app.model.entity.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILibroService {
	Iterable<Libro> findAll();

	// Ojo importar de Spring Data Domain
	Page<Libro> listar(Pageable pageable);

	void save(Libro libro);

	void insert(Libro libro);

	void update(Libro libro);

	Libro findOne(Long id);

	void delete(Long id);

}