package com.informatorio.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmpleadoTest {
	
	Empleado emp = new Empleado("src/test/java/com/informatorio/utils/EmpleadoTest.txt");
	List<Persona> listaPersonas = emp.creaListaPersona();
	
	@Test
	public void creaListaPersona_Test() {
		// Crea una lista de objetos Persona a partir de un archivo .txt
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona("Carlos","Sanchez","20-01-1980","45678.08"));
		lista.add(new Persona("Franco","Muñoz","20-02-1982","41678.08"));
		lista.add(new Persona("Jose","Suarez","20-03-1983","42678.08"));
		lista.add(new Persona("Lucia","Martinez","20-04-1984","43678.08"));
		lista.add(new Persona("Sofia","Lujan","20-05-1985","44678.08"));
		lista.add(new Persona("Franco","Aguirre","20-02-1982","41678.08"));
		assertEquals(lista, listaPersonas);
	}
	
	@Test
	public void crear_Test() {
		// Crea un objeto Persona a partir de un string
		String args = "Franco,Muñoz,10-03-2021,4326.12";
		Persona persona = emp.crear(args);
		assertEquals("Franco Muñoz: $4326.12", persona.toString());
	}

	@Test
	public void getMasViejo_Test() {
		// Devuelve el objeto Persona de mayor edad
		Persona persona = emp.getMasViejo(listaPersonas);
		assertEquals("Carlos Sanchez: $45678.08", persona.toString());
	}

	@Test
	public void getMasJoven_Test() {
		// Devuelve el objeto Persona de menor edad
		Persona persona = emp.getMasJoven(listaPersonas);
		assertEquals("Sofia Lujan: $44678.08", persona.toString());
	}

	@Test
	public void getMayorSueldo_Test() {
		// Devuelve el objeto Persona de mayor sueldo
		Persona persona = emp.getMayorSueldo(listaPersonas);
		assertEquals("Carlos Sanchez: $45678.08", persona.toString());
	}

	@Test
	public void getMenorSueldo_Test() {
		// Devuelve el objeto de menor sueldo
		Persona persona = emp.getMenorSueldo(listaPersonas);
		assertEquals("Franco Muñoz: $41678.08", persona.toString());
	}

	@Test
	public void getOrdenABC_Test() {
		// Devuelve la lista de objetos Persona ordenada alfabéticamente
		List<Persona> lista = emp.getOrdenABC(listaPersonas);
		List<Persona> lista2 = new ArrayList<>();
		lista2.add(new Persona("Carlos","Sanchez","20-01-1980","45678.08"));
		lista2.add(new Persona("Franco","Muñoz","20-02-1982","41678.08"));
		lista2.add(new Persona("Franco","Aguirre","20-02-1982","41678.08"));
		lista2.add(new Persona("Jose","Suarez","20-03-1983","42678.08"));
		lista2.add(new Persona("Lucia","Martinez","20-04-1984","43678.08"));
		lista2.add(new Persona("Sofia","Lujan","20-05-1985","44678.08"));
		assertEquals(lista2, lista);
	}
}
