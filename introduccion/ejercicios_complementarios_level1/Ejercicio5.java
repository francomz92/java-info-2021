import java.util.Scanner;

/* Se desea una aplicación que solicite 2 números enteros y realice la operación
de multiplicación por sumas sucesivas (sin uso de librerías). */

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] valores = pedirDatos();
        int valor1 = valores[0];
        int valor2 = valores[1];

        System.out.println("--------");

        multiplicacion(valor1, valor2);
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

    // Calcula la multiplicación valor1 x valor2
    static void multiplicacion(int valor1, int valor2) {
        int resultado = valor1 * valor2;
        String mensaje = String.format("%d x %d = %d", valor1, valor2, resultado);
        System.out.println(mensaje);
    }
}
