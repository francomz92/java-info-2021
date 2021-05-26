import java.util.Scanner;

/* Ejercicio 2: Realizar un programa que al ejecutar se pueda ingresar 3 numeros enteros,
para luego imprimirlos por pantalla de la siguiente manera:
El primer nro ingresado es: 4
El segundo nro ingresado es: 5
El tercer nro ingresado es: 6
*/

public class Ejercicio2 {
    public static void main(String[] args) {
        ingresaNumeros();
    }

    // Lee números ingresados y los imprime por consola
    static public void ingresaNumeros() {
        // Instancia de Scaner
        Scanner sc = new Scanner(System.in);
        // Entrada de datos
        System.out.println("Ingrese el primer número entero: ");
        int numero1 = sc.nextInt();
        System.out.println("Ingrese el segundo número entero: ");
        int numero2 = sc.nextInt();
        System.out.println("Ingrese el tercer número entero: ");
        int numero3 = sc.nextInt();
        // Cierre de instancia Scaner
        sc.close();

        imprimirNumeros(numero1, numero2, numero3);
    }

    // Impreción de valores ingresados
    static void imprimirNumeros(int primero, int segundo, int tercero) {
        System.out.println("El primer nro ingresado es: " + primero);
        System.out.println("El segundo nro ingresado es: " + segundo);
        System.out.println("El tercer nro ingresado es: " + tercero);
    }
}
