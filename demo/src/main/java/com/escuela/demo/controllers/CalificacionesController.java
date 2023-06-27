package com.escuela.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalificacionesController {
	@GetMapping("/calificaciones")
	public String  calificaciones() {
		return "calificaciones";
	}
}
