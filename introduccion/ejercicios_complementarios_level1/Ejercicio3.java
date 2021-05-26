import java.util.Scanner;

/* Confeccionar un programa que dado un número entero como dato de entrada imprima
la secuencia de números (incrementos de 1) de la siguiente forma:
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        int valor = pedirNumero();

        System.out.println("--------");

        secuencia(valor);
    }

    static int pedirNumero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero:");
        int numero = sc.nextInt();
        sc.close();
        return numero;
    }

    // Imprime una secuencia de valores por cada vuelta de ciclo
    static void secuencia(int valor) {
        String valores = "";
        for (int i = 1; i <= valor; i++) {
            valores += i;
            System.out.println(valores);
        }
    }
}