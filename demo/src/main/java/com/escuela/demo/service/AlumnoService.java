package com.escuela.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escuela.demo.model.Alumno;
import com.escuela.demo.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public Alumno create (Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	public List<Alumno> getAll () {
		return alumnoRepository.findAll();
	}
	
	public Alumno update (Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	public void delete (Alumno alumno) {
		alumnoRepository.delete(alumno);
	}

}
