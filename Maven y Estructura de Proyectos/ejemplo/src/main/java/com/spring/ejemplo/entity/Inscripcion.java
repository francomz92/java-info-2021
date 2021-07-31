package com.spring.ejemplo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Inscripcion {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Alumno alumno;
	@ManyToOne
	private Curso curso;
	private LocalDate fechaInscripcion;


	public Long getId() {return id;}
	public void setId(Long id) {
		this.id = id;
	}
	public Alumno getAlumno() {return this.alumno;}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Curso getCurso() {return this.curso;}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public LocalDate getFechaInscripcion() {return this.fechaInscripcion;}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	@Override
	public String toString() {
		return String.format("Inscripción: %d %s %s",
		this.id, this.alumno.getNombreCompleto(),
		this.curso.getNombre()
		);
	}
}
