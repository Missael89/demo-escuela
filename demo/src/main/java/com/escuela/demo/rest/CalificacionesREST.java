package com.escuela.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.demo.model.Calificaciones;
import com.escuela.demo.service.CalificacionesService;

@RestController
@RequestMapping ("/api/calificaciones/")
public class CalificacionesREST {
	
	@Autowired
	private CalificacionesService calificacionesService;
	
	@PostMapping
	private String agregar (@RequestBody Calificaciones calificaciones) {
		Calificaciones temp = calificacionesService.create(calificaciones);
		
		try {
			ResponseEntity.created(new URI("/api/calificaciones"+temp.getId_t_calificaciones())).body(temp);
			return "{\"success\":\"ok\", \"msg\":\"calificacion registrada\"}";
			
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			return "{\"success\":\"error\", \"msg\":\"error al registrar calificacion\"}";
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Calificaciones>> listarTodo () {
		return ResponseEntity.ok(calificacionesService.getAll());
	}
	
	@PutMapping
	private String actualizar (@RequestBody Calificaciones calificaciones) {
		Calificaciones temp = calificacionesService.update(calificaciones);
		
		try {
			ResponseEntity.created(new URI("/api/calificaciones"+temp.getId_t_calificaciones())).body(temp);
			return "{\"success\":\"ok\", \"msg\":\"calificacion actualizada”}";
			
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			return "{\"success\":\"error\", \"msg\":\"error al actualizar calificacion\"}";
		}
	}
	
	@DeleteMapping
	private String eliminar (@RequestBody Calificaciones calificaciones) {
		calificacionesService.delete(calificaciones);
		return "{\"success\":\"ok\", \"msg\":\"calificacion eliminada”}";
	}
	
	@GetMapping (value = "{id_t_calificaciones}")
	private ResponseEntity<Optional<Calificaciones>> listar (@PathVariable ("id_t_calificaciones") Long id_t_calificaciones) {
		return ResponseEntity.ok(calificacionesService.findById(id_t_calificaciones));
	}

}
