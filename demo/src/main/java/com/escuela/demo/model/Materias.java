package com.escuela.demo.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "t_materias")
public class Materias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_t_materias;
	
	private String nombre;
	private int activo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "materias")
	private List<Calificaciones> calificaciones;

	public Materias() {
		super();
	}

	public Materias(int id_t_materias, String nombre, int activo, List<Calificaciones> calificaciones) {
		super();
		this.id_t_materias = id_t_materias;
		this.nombre = nombre;
		this.activo = activo;
		this.calificaciones = calificaciones;
	}

	public int getId_t_materias() {
		return id_t_materias;
	}

	public void setId_t_materias(int id_t_materias) {
		this.id_t_materias = id_t_materias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public List<Calificaciones> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
