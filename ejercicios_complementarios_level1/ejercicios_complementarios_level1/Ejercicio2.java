package ejercicios_complementarios_level1;

import java.util.Scanner;

/* Realizar un programa que solicite por consola 2 números enteros. Para luego imprimir
el resultado de la suma, resta, multiplicación, división y módulo (resto de la división)
de ambos números. */

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] valores = pedirNumeros();
        int valor1 = valores[0];
        int valor2 = valores[1];

        System.out.println("---------");

        suma(valor1, valor2);
        resta(valor1, valor2);
        multiplicacion(valor1, valor2);
        division(valor1, valor2);
        modulo(valor1, valor2);
    }

    // Retorna una lista con dos números ingresados por consola
    static int[] pedirNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dos número enteros");
        int numero1 = sc.nextInt();
        int numero2 = sc.nextInt();
        sc.close();
        int[] valores = {numero1, numero2};
        return valores;
    }

    // Calcula la suma valor1 + valor2
    static void suma(int valor1, int valor2) {
        int resultado = valor1 + valor2;
        String mensaje = String.format("%d + %d = %d", valor1, valor2, resultado);
        System.out.println(mensaje);
    }
    
    // Calcula la resta valor1 - valor2
    static void resta(int valor1, int valor2) {
        int resultado = valor1 - valor2;
        String mensaje = String.format("%d - %d = %d", valor1, valor2, resultado);
        System.out.println(mensaje);
    }
    
    // Calcula la multiplicación valor1 x valor2
    static void multiplicacion(int valor1, int valor2) {
        int resultado = valor1 * valor2;
        String mensaje = String.format("%d * %d = %d", valor1, valor2, resultado);
        System.out.println(mensaje);
    }
    
    // Calcula la división valor1 / valor2
    static void division(int valor1, int valor2) {
        double resultado = (double)valor1 / valor2;
        String mensaje = String.format("%d / %d = %.2f", valor1, valor2, resultado);
        System.out.println(mensaje);
    }
    
    // Calcula el módulo valor1 % valor2
    static void modulo(int valor1, int valor2) {
        int resultado = valor1 % valor2;
        String mensaje = valor1 + " % " + valor2 + " = " + resultado;
        System.out.println(mensaje);
    }
}
