package com.midominio.evaluable2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.midominio.evaluable2.app.model.entity.Usuario;
import com.midominio.evaluable2.app.service.IUsuarioService;

@RestController
@RequestMapping("/rest")
public class RestUsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;

	@GetMapping("/usuarios")
	public Iterable<Usuario> m(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario c1 (@PathVariable Long id) {
		return usuarioService.findOne(id);
	}
	
	
	@PutMapping("/usuario")
	public void actualizar (@RequestBody Usuario usuario) {
		usuarioService.update(usuario);
	}
	
	@PostMapping("/usuario")
	public void crearUsuario (@RequestBody Usuario usuario) {
		usuarioService.insert(usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario (@PathVariable Long id) {
		
		usuarioService.delete(id);
	}
	
	
}
