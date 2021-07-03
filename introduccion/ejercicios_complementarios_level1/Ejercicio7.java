import java.util.Scanner;

/* Realizar un Programa que dado un String de entrada en minúsculas lo convierta
por completo a mayúsculas. Sin uso de métodos o librerías que realicen toUppercase(). */

public class Ejercicio7 {
    public static void main(String[] args) {
        mayusculaString();
    }

    // Convierte un texto ingresado en minusculas a un texto en mayusculas
    static void mayusculaString() {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        sc.close();
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i] = mayusculaChar(caracteres[i]);
        }
        caracteres.toString();
        System.out.println(caracteres);
    }

    // Convierte un caracter de minuscula a mayuscula
    static char mayusculaChar(char valor) {
        int upper = (int)valor - (int)'a' + (int)'A';
        char nuevo = (char)upper;
        return nuevo;
    }
}
