package com.escuela.demo.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "t_calificaciones")
public class Calificaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_t_calificaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_t_materias")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Materias materias;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_t_usuarios")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Alumno alumno;
	
	private double calificacion;
	private Timestamp fecha_registro;
	
	
	
	public Calificaciones() {
		super();
	}

	public Calificaciones(Long id_t_calificaciones, Materias materias, Alumno alumno, double calificacion,
			Timestamp fecha_registro) {
		super();
		this.id_t_calificaciones = id_t_calificaciones;
		this.materias = materias;
		this.alumno = alumno;
		this.calificacion = calificacion;
		this.fecha_registro = fecha_registro;
	}

	public Long getId_t_calificaciones() {
		return id_t_calificaciones;
	}

	public void setId_t_calificaciones(Long id_t_calificaciones) {
		this.id_t_calificaciones = id_t_calificaciones;
	}

	public Materias getMaterias() {
		return materias;
	}

	public void setMaterias(Materias materias) {
		this.materias = materias;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Timestamp getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Timestamp fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
