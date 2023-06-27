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
@Table (name = "t_alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_t_usuarios;
	
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private int activo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "alumno")
	private List<Calificaciones> calificaciones;	

	public Alumno() {
		super();
	}

	public Alumno(int id_t_usuarios, String nombre, String ap_paterno, String ap_materno, int activo,
			List<Calificaciones> calificaciones) {
		super();
		this.id_t_usuarios = id_t_usuarios;
		this.nombre = nombre;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.activo = activo;
		this.calificaciones = calificaciones;
	}

	public int getId_t_usuarios() {
		return id_t_usuarios;
	}

	public void setId_t_usuarios(int id_t_usuarios) {
		this.id_t_usuarios = id_t_usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
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
