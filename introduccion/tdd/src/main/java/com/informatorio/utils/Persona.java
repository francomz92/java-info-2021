package com.informatorio.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Persona {
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected BigDecimal sueldo;

	public Persona(String nombre, String apellido, String fechaNacimiento, String sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = toFecha(fechaNacimiento);
		// this.sueldo = toSueldo(sueldo);
		this.sueldo = new BigDecimal(sueldo);
	}

	private LocalDate toFecha(String fechaNacimiento) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);
		return fecha;
	}

	protected int edad() {
		int diferencia = (int) ChronoUnit.DAYS.between(this.fechaNacimiento, LocalDate.now());
		return diferencia/365;
	}

	@Override
	public String toString() {
		return this.nombre + " " + this.apellido + ": $" + this.sueldo;
	}
}