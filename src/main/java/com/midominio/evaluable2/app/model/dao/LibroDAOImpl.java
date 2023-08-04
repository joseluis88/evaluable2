package com.midominio.evaluable2.app.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.midominio.evaluable2.app.model.entity.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibroDAOImpl{

	@PersistenceContext
	private EntityManager em;

	// @Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Libro", Libro.class).getResultList();
	}

	// @Override
	public void save(Libro libro) {
		if (libro.getId() != null && libro.getId() > 0)
			// Actualiza
			em.merge(libro);
		else
			// Inserta
			em.persist(libro);
	}

	// @Override
	public Libro findOne(Long id) {
		return em.find(Libro.class, id);
	}

	// @Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}
}