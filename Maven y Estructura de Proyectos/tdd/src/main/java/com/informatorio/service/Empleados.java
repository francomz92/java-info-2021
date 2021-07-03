package com.informatorio.service;

import java.util.List;

import com.informatorio.utils.Empleado;
import com.informatorio.utils.Persona;

public class Empleados {
	public static void main(String[] args) {
        System.out.println("---------");
        String archivo = "src/main/java/com/informatorio/utils/ejercicio5.txt";
		Empleado emp = new Empleado(archivo);
        List<Persona> listaPersonas = emp.creaListaPersona();
        String letra = "s".toUpperCase();
        System.out.println("Personas cuyo apellido comienza con " + letra);
        emp.empiezaCon(listaPersonas, letra);
        System.out.println("---------");
        System.out.println("El/La más viejo es: " + emp.getMasViejo(listaPersonas));
        System.out.println("El/La más joven es: " + emp.getMasJoven(listaPersonas));
        System.out.println("El/La que más gana es: " + emp.getMenorSueldo(listaPersonas));
        System.out.println("El/La que menos gana es: " + emp.getMayorSueldo(listaPersonas));
        System.out.println("Ordenado alfaveticamente:");
        System.out.println(emp.getOrdenABC(listaPersonas));
    }
    
}
