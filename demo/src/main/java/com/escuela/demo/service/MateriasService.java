package com.escuela.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escuela.demo.model.Materias;
import com.escuela.demo.repository.MateriasRepository;

@Service
public class MateriasService {
	
	@Autowired
	private MateriasRepository materiasRepository;
	
	public Materias create (Materias materias) {
		return materiasRepository.save(materias);
	}
	
	public List<Materias> getAll () {
		return materiasRepository.findAll();
	}
	
	public Materias update (Materias materias) {
		return materiasRepository.save(materias);
	}
	
	public void delete (Materias materias) {
		materiasRepository.delete(materias);
	}

}
