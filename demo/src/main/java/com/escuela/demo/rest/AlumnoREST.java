package com.escuela.demo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.escuela.demo.model.Alumno;
import com.escuela.demo.service.AlumnoService;



@RestController
@RequestMapping ("/api/alumno/")
public class AlumnoREST {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	private ResponseEntity<List<Alumno>> listarTodo () {
		return ResponseEntity.ok(alumnoService.getAll());
	}

}
