package guia_practica;

/* Ejercicio 1: Realizar un programa que realice la impresión por consola del siguiente
mensaje: Hola Informatorio 2020!! */

public class Ejercicio1 {
    public static void main(String[] args) {
        String saludo = "Hola Informatorio 2020!!";
        saludar(saludo);
    }

    static void saludar(String texto) {
        System.out.println(texto);
    }
}
