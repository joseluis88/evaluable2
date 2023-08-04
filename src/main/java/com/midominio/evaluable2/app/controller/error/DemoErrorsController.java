package com.midominio.evaluable2.app.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoErrorsController {
	
	
	@GetMapping({"error404/","error404"})
	public String error404(Model modelo) {
		modelo.addAttribute("titulo","Error Titulo");
		modelo.addAttribute("cabecera","Error Cabecera");
		return "error/error400";
	}
	
	@GetMapping({"division0"})
	public String division0(Model modelo) {
		int x=8/0;
		return "error/division0";
	}
	
	@GetMapping({"null"})
	public String metodoNull(Model modelo) {
		String string = null;
		string.chars();
		return "error/null";
	}
	
	
}
