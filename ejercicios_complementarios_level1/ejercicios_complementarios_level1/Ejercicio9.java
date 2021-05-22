package ejercicios_complementarios_level1;

import java.util.Scanner;

/* Dado un String de entrada (frase, texto, etc) calcular la cantidad de veces
que aparece una letra dada. */

public class Ejercicio9 {
    public static void main(String[] args) {
        String[] datos = pedirTextoYLetra();
        String cadena = datos[0];
        String letra = datos[1];

        System.out.println("---------");

        conteoLetra(cadena, letra);
    }

    // Cuenta la cantidad de veces que se repite una letra en un texto
    static void conteoLetra(String cadena, String letra) {
        char[] letras = cadena.toCharArray();
        char caracter = letra.charAt(0);
        int cantidad = 0;
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == caracter) {
                cantidad ++;
            }
        }
        String mensaje = String.format("La letra %s se repite %d veces", letra, cantidad);
        System.out.println(mensaje);
    }

    static String[] pedirTextoYLetra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un texto:");
        String texto = sc.nextLine();
        System.out.println("Ingrese la letra que desea contar:");
        String letra = sc.nextLine();
        sc.close();
        String[] datos = {texto, letra};
        return datos;
    }
}
