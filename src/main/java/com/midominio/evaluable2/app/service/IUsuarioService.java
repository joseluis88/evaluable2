package com.midominio.evaluable2.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.midominio.evaluable2.app.model.entity.Usuario;

public interface IUsuarioService {
	Iterable<Usuario> findAll();

	// Ojo importar de Spring Data Domain
	Page<Usuario> listar(Pageable pageable);

	void save(Usuario usuario);

	void insert(Usuario usuario);

	void update(Usuario usuario);

	Usuario findOne(Long id);

	void delete(Long id);

}