package com.escuela.demo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.demo.model.Materias;
import com.escuela.demo.service.MateriasService;

@RestController
@RequestMapping ("/api/materias/")
public class MateriasREST {
	
	@Autowired
	private MateriasService materiasService;
	
	@GetMapping
	private ResponseEntity<List<Materias>> listarTodo () {
		return ResponseEntity.ok(materiasService.getAll());
	}

}
