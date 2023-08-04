package com.midominio.evaluable2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.evaluable2.app.model.dao.IUsuarioDAO;
import com.midominio.evaluable2.app.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub

		usuarioDAO.save(usuario);

	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		// usuarioDAO.delete(id);
		usuarioDAO.deleteById(id);
	}

	@Override
	@Transactional
	public void insert(Usuario usuario) {
		if (usuario.getId() == null) {
			usuarioDAO.save(usuario);
		}
	}

	@Override
	@Transactional
	public void update(Usuario usuario) {
		if (usuario.getId() != null) {
			usuarioDAO.save(usuario);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> listar(Pageable pageable) {
		return usuarioDAO.findAll(pageable);
	}

}
