package com.informatorio.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonaTest {
	
	Persona persona = new Persona("Franco", "Muñoz", "10-02-2000", "45200.22");

	@Test
	public void crea_instancia_de_Persona() {
		// Crea una un objeto persona a partir de 4 argumentos de tipo strings
		assertEquals("Franco Muñoz: $45200.22", persona.toString());
	}

	@Test
	public void edadTest() {
		// Devuleve un valor entero a partir de la fecha de nacimiento de un objeto Persona
		int edad = persona.edad();
		assertEquals(21, edad);
	}
}
