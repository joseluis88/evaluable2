package com.midominio.evaluable2.app.controller.error;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", "Causa del error: " + ex.getMessage());
		model.addAttribute("status", "Tipo de error: " + HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", "Fecha del error: " + LocalDate.now());
		return "error/internal-error";
	}

	@ExceptionHandler(NullPointerException.class)
	public String templateInputError(NullPointerException ex, Model model) {
		model.addAttribute("error", "Error null pointer");
		model.addAttribute("message", "Causa del error: " + ex.getMessage());
		model.addAttribute("status", "Tipo de error: " + HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", "Fecha del error: " + LocalDate.now());
		return "error/internal-error";
	}
}
