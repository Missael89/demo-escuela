package com.escuela.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {
	@GetMapping("/alumno")
	public String alumno() {
		return "alumno";
	}
}
