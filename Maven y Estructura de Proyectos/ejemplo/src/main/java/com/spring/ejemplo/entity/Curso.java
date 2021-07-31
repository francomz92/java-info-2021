package com.spring.ejemplo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id
	private Long id;
	private String nombre;


	public Long getId() {return id;}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {return this.nombre;}
	
}
