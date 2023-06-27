package com.escuela.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escuela.demo.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
