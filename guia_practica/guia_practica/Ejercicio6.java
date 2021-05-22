package guia_practica;
import java.util.Scanner;

/* Ejercicio 6: Debemos realizar un programa que nos realizará una pregunta si queremos realizar
una operación dada o si deseamos salir/terminar el programa.
Utilizaremos en este caso una simple operación que nos pide un número y luego lo imprime. */

public class Ejercicio6 {
    public static void main(String[] args) {
        operacion();
    }

    // Ciclo de elecciones
    static void operacion() {
        Scanner sc = new Scanner(System.in);
        int comienzo = 1;
        while (comienzo != 2) {
            // Menú de opciones
            System.out.println("Que desea hacer.?");
            System.out.println("1- Algo");
            System.out.println("2- Otra cosa");
            int eleccion = sc.nextInt();
            System.out.println("---------");
            // Opción elejida
            System.out.println("Su eleccion fue la número " + eleccion);
            System.out.println("---------");
            // Continuar/Salir
            System.out.println("1- Continuar.?");
            System.out.println("2- Salir");
            comienzo = sc.nextInt();
        }
        sc.close();
    }

}
