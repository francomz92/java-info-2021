package com.spring.ejemplo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Alumno {

	@Id
	private Long id;
	private String nombre;
	private String apellido;

	public Alumno() {}

	@OneToMany
	private List<Inscripcion> inscripciones;

	public Long getId() {return id;}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {return this.nombre;}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {return this.apellido;}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreCompleto() {
		return String.format("s% s%", this.nombre, this.apellido);
	}

	@Override
	public String toString() {
		return String.format("Usuario: %s %s", this.nombre, this.apellido);
	}

}
