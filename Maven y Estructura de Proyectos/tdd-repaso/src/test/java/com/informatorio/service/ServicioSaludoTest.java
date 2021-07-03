package com.informatorio.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ServicioSaludoTest
 */
public class ServicioSaludoTest {

	private static final String nombre = "Carlos";

	@Test
	public void saludoPersona() {
		// Dado un un nombre "Carlos"
		// When
		String saludo = ServicioSaludo.saludoPersona(nombre);
		// Then
		assertEquals("Hola Carlos", saludo);
	}

	@Test
	public void saludoPersonaNull() {
		// Dado un un nombre "Carlos"
		// When
		String saludo = ServicioSaludo.saludoPersona(null);
		// Then
		assertEquals("Hola", saludo);
	}

	@Test
	public void saludoPersonaEspaciosEnBlanco() {
		// Dado un un nombre "Carlos"
		// When
		String saludo = ServicioSaludo.saludoPersona("      ");
		// Then
		assertEquals("Hola", saludo);
	}
}