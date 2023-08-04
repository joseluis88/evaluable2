package com.midominio.evaluable2.app.controller;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.evaluable2.app.model.entity.Libro;
import com.midominio.evaluable2.app.service.ILibroService;
import com.midominio.evaluable2.app.utils.paginator.PageRender;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private ILibroService libroService;

	// Esta hay que adaptarla para que pagine
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libro/listar", libros);
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libro/listar";
	}
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de libro");
		model.put("libro", new Libro());
		return "libro/form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Libro libro, BindingResult result, @RequestParam("file") MultipartFile foto,
			RedirectAttributes flash, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de libro");
			return "libro/form";
		}

		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src/main/resources/static/upload");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "/" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Subido correctamente " + foto.getOriginalFilename());
				libro.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {
			}
		}

		libroService.save(libro);
		flash.addFlashAttribute("success", "Artículo guardado con éxito");
		return "redirect:listar";

	}

	@GetMapping("/form/{id}")
	public String actualiza(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Libro libro = null;
		if (id > 0) {
			libro = libroService.findOne(id);
			if (libro == null)
				return "redirect:/libro/listar";

		} else {
			return "redirect:/libro/listar";
		}

		model.addAttribute("libro", libro);
		model.addAttribute("titulo", "Editar libro");
		flash.addFlashAttribute("warning", "Artículo borrado con éxito");
		return "libro/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if (id > 0) {
			libroService.delete(id);
			flash.addFlashAttribute("warningDelete", "Libro borrado con éxito");
		}
		return "redirect:/libro/listar";
	}

}
