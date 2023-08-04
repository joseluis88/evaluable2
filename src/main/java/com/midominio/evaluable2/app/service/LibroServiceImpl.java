 package com.midominio.evaluable2.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.evaluable2.app.model.dao.ILibroDAO;
import com.midominio.evaluable2.app.model.entity.Libro;

@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
	private ILibroDAO libroDAO;

	@Override
	@Transactional(readOnly = true)
	public Iterable <Libro> findAll() {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		// TODO Auto-generated method stub
		
		libroDAO.save(libro);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Libro findOne(Long id) {
		// TODO Auto-generated method stub
		return libroDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		//libroDAO.delete(id);
		libroDAO.deleteById(id);
	}
	
	@Override
	@Transactional
	public void insert(Libro libro) {
		if(libro.getId() == null) {
			libroDAO.save(libro);
		}
	}
	
	@Override
	@Transactional
	public void update(Libro libro) {
		if(libro.getId() != null) {
			libroDAO.save(libro);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Libro> listar(Pageable pageable) {
		return libroDAO.findAll(pageable);
	}

}
