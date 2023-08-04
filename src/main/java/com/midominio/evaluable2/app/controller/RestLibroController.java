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

import com.midominio.evaluable2.app.model.entity.Libro;
import com.midominio.evaluable2.app.service.ILibroService;

@RestController
@RequestMapping("/rest")
public class RestLibroController {
	
	@Autowired
	ILibroService libroService;

	@GetMapping("/libros")
	public Iterable<Libro> m(){
		return libroService.findAll();
	}
	
	@GetMapping("/libro/{id}")
	public Libro c1 (@PathVariable Long id) {
		return libroService.findOne(id);
	}
	
	
	@PutMapping("/libro")
	public void actualizar (@RequestBody Libro libro) {
		libroService.update(libro);
	}
	
	@PostMapping("/libro")
	public void crearLibro (@RequestBody Libro libro) {
		libroService.insert(libro);
	}
	
	@DeleteMapping("/libro/{id}")
	public void deleteLibro (@PathVariable Long id) {
		
		libroService.delete(id);
	}
	
	
}
