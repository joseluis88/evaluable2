package com.midominio.evaluable2.app.controller.error;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(ArithmeticException ex, Model modelo) {
		modelo.addAttribute("error", "Error de aritmética");
		modelo.addAttribute("message", ex.getMessage());
		modelo.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", LocalDate.now());
		modelo.addAttribute("trace", ex.getStackTrace());
		return "error/internal-error";
	}
}

















