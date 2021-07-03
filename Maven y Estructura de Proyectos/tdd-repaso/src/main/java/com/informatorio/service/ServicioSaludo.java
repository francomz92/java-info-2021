package com.informatorio.service;

/**
 * ServicioSaludo
 */
public class ServicioSaludo {

	public static String saludoPersona(String persona) {
		if (persona != null && !persona.trim().isBlank()) {
			return "Hola " + persona.trim();
		}
		return "Hola";
	}
}