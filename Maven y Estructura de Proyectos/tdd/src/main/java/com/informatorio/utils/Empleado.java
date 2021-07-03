package com.informatorio.utils;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Empleado {
    /* public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        System.out.println("---------");
        creaListaPersona(listaPersonas);
        String letra = "s".toUpperCase();
        System.out.println("Personas cuyo apellido comienza con " + letra);
        empiezaCon(listaPersonas, letra);
        System.out.println("---------");
        System.out.println("El/La más viejo es: " + getMasViejo(listaPersonas));
        System.out.println("El/La más joven es: " + getMasJoven(listaPersonas));
        System.out.println("El/La que más gana es: " + getMenorSueldo(listaPersonas));
        System.out.println("El/La que menos gana es: " + getMayorSueldo(listaPersonas));
        System.out.println("Ordenado alfaveticamente:");
        System.out.println(getOrdenABC(listaPersonas));
    }
     */
	// Lee el archivo Ejercicio5.txt y crea una instancia de Persona por cada linea
    public Empleado(String archivo) {
        this.archivo = archivo;
    }

    private String archivo;

    public List<Persona> creaListaPersona() {
        List<Persona> listaPersonas = new ArrayList<>();
        // String archivo = "ejercicio5.txt";
        try (Stream<String> stream = Files.lines(Paths.get(this.archivo))){
            stream.forEach((e) -> {
				Persona persona = crear(e);
				listaPersonas.add(persona);
			});
            return listaPersonas;
        } catch (Exception e) {
            System.out.println("Ocurrió un error.!! " + e.getMessage());
        }
        return null;
    }

	protected Persona crear(String linea) {
		String[] lista = linea.split(",");
		String nombre = lista[0];
		String apellido = lista[1];
		String fechaNacimiento = lista[2];
		String sueldo = lista[3];
		Persona persona = new Persona(nombre, apellido, fechaNacimiento, sueldo);
		return persona;
	}

    // Muestra las personas cuyo apellido comience con "letra"
    public void empiezaCon(List<Persona> listaPersonas, String letra) {
        listaPersonas.forEach((e) -> {
            if (e.apellido.toLowerCase().startsWith(letra.toLowerCase())) {
                System.out.println(e);
            }
        });
    }

    // Muestra la persona con mayor edad
    public Persona getMasViejo(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            int comp = 0;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp < listaPersonas.get(i).edad()) {
                    comp = listaPersonas.get(i).edad();
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).edad() == comp) {
                    System.out.println(listaPersonas.get(i).edad());
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }

    // Muestra la persona con menor edad
    public Persona getMasJoven(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            int comp = listaPersonas.get(0).edad();
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp > listaPersonas.get(i).edad()) {
                    comp = listaPersonas.get(i).edad();
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).edad() == comp) {
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }

    // Muestra la persona que gana más
    public Persona getMayorSueldo(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            BigDecimal comp = listaPersonas.get(0).sueldo;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp.compareTo(listaPersonas.get(i).sueldo) == -1 ) {
                    comp = listaPersonas.get(i).sueldo;
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).sueldo == comp) {
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }
    
    // Muestra la persona que gana menos
    public Persona getMenorSueldo(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            BigDecimal comp = listaPersonas.get(0).sueldo;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp.compareTo(listaPersonas.get(i).sueldo) == 1 ) {
                    comp = listaPersonas.get(i).sueldo;
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).sueldo == comp) {
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }

    // Ordena alfaveticamente la lista de personas
    public List<Persona> getOrdenABC(List<Persona> listaPersonas) {
        // Collections.sort(lista);
        listaPersonas.sort((o1, o2) -> o1.nombre.compareTo(o2.nombre));
        return listaPersonas;
    }
}