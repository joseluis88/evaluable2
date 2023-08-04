package com.midominio.evaluable2.app.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.midominio.evaluable2.app.model.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDAOImpl{

	@PersistenceContext
	private EntityManager em;

	// @Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	// @Override
	public void save(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() > 0)
			// Actualiza
			em.merge(usuario);
		else
			// Inserta
			em.persist(usuario);
	}

	// @Override
	public Usuario findOne(Long id) {
		return em.find(Usuario.class, id);
	}

	// @Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}
}