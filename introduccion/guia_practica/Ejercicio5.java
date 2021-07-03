import java.util.Scanner;

/* Ejercicio 5: Desarrollar un programa que dado un número entero ingresado, nos retorne los
valores de ese número multiplicado por 1, 2, 3, … y 10. */

public class Ejercicio5 {
    public static void main(String[] args) {
        int valor = ingresaNumero();
        multiplicar(valor);
    }

    // Multiplica un número por los valores de un rango del 1 al 10 inclusive y los imprime por pantalla
    static void multiplicar(int numero) {
        for (int i = 1; i < 11; i++) {
            int resultado = numero * i;
            String formato = "%d*%d = %d";
            String mensaje = String.format(formato, numero, i, resultado);
            System.out.println(mensaje);
        }
    }

    // Lee un valor ingresado por consola
    static int ingresaNumero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int numero = sc.nextInt();
        sc.close();
        System.out.println("--------");
        return numero;
    }
}
