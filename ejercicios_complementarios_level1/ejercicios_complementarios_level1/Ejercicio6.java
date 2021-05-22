package ejercicios_complementarios_level1;

import java.util.Scanner;

/* Se desea una aplicación que solicite 2 números enteros y realice la operación
de potencia (sin uso de librerías). */

public class Ejercicio6 {
    public static void main(String[] args) {
        int[] valores = pedirDatos();
        int valor1 = valores[0];
        int valor2 = valores[1];

        System.out.println("--------");

        potencia(valor1, valor2);
    }

    static int[] pedirDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese 2 números enteros:");
        int numero1 = sc.nextInt();
        int numero2 = sc.nextInt();
        sc.close();
        int[] valores = {numero1, numero2};
        return valores;
    }

    // Calcula la potencia valor1 elevado a valor2
    static void potencia(int valor1, int valor2) {
        int resultado = valor1;
        for (int i = 1; i < valor2 ; i++) {
            resultado *= valor1;
        }
        String mensaje = String.format("%d elvedo a %d = %d", valor1, valor2, resultado);
        System.out.println(mensaje);
    }
}
