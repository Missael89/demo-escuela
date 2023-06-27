package com.escuela.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MateriasController {
	@GetMapping("/materias")
	public String materias() {
		return "materias";
	}
}
