package guia_practica;
import java.util.Scanner;

/* Ejercicio 3: Tendremos un sistema que debe clasificar el resultado de una evaluación.
Como dato de entrada tendremos un entero y como resultado un String de la clasificación de
la siguiente forma:

Rango               Clasificación
93-100              Exceclente
85-92               Sobresaliente
75-84               Distinguido
60-74               Bueno
00-59               Desaprobado
*/

public class Ejercicio3 {
    public static void main(String[] args) {
        clasificacion();    
    }

    // Clacifica notas
    public static void clasificacion() {
        int valor = nota();
        // Clasificación de notas
        if (valor >= 0 && valor <= 59) {
            System.out.println("Desaprobado");
        } else if (valor <= 74) {
            System.out.println("Bueno");
        } else if (valor <= 84) {
            System.out.println("Distinguido");
        } else if (valor <= 92) {
            System.out.println("Sobresaliente");
        } else {
            System.out.println("Excelente");
        }
    }

    // Lectura de datos ingresados por consola
    static int nota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nota: ");
        int entero = sc.nextInt();
        sc.close();
        return entero;
    }
}
