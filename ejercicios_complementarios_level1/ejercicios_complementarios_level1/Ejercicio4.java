package ejercicios_complementarios_level1;

/* Realizar un programa que calcule el factorial de un número:
n! = 1 x 2 x 3 x 4 x 5 x … x (n-1) x n.
Sin hacer uso de librerías. */

public class Ejercicio4 {
    public static void main(String[] args) {
        factorial(5);
    }

    // Calcura el factorial de un valor
    static void factorial(int valor) {
        int resultado = 1;
        for (int i = 1; i <= valor; i++) {
            resultado *= i;
        }
        String mensaje = String.format("El factorial de %d es: %d", valor, resultado);
        System.out.println(mensaje);
    }
}
