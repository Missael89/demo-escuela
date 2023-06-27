package com.escuela.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escuela.demo.model.Calificaciones;
import com.escuela.demo.repository.CalificacionesRepository;

@Service
public class CalificacionesService {
	
	@Autowired
	private CalificacionesRepository calificacionesRepository;
	
	public Calificaciones create (Calificaciones calificaciones) {
		return calificacionesRepository.save(calificaciones);
	}
	
	public List<Calificaciones> getAll () {
		return calificacionesRepository.findAll();
	}
	
	public Calificaciones update (Calificaciones calificaciones) {
		return calificacionesRepository.save(calificaciones);
	}
	
	public void delete (Calificaciones calificaciones) {
		calificacionesRepository.delete(calificaciones);
	}
	
	public Optional<Calificaciones> findById (Long id_t_calificaciones) {
		return calificacionesRepository.findById(id_t_calificaciones);
	}

}
