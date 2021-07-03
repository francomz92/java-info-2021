import java.util.HashMap;
import java.util.Scanner;

/* Ejercicio 4: Realizar un programa que dado un número de entrada entre 1 a 7, nos devuelva
el dia de la semana de la siguiente forma:

Número              Día
1                   Domingo
2                   Lunes
3                   Martes
4                   Miércoles
5                   Jueves
6                   Viernes
7                   Sábado
*/

public class Ejercicio4 {
    public static void main(String[] args) {
        int numero = numeroDia();
        nombreDia(numero);
    }

    // Lee un número ingresado por consola
    static int numeroDia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número del 1 al 7: ");
        int numero = sc.nextInt();
        sc.close();
        return numero;
    }

    // Muestra el día de la semana correspondiente al número ingresado
    static void nombreDia(int numero) {
        HashMap<Integer, String> semana = new HashMap<Integer, String>();
        semana.put(1, "Domingo");
        semana.put(2, "Lunes");
        semana.put(3, "Martes");
        semana.put(4, "Miercoles");
        semana.put(5, "Jueves");
        semana.put(6, "Viernes");
        semana.put(7, "Sabado");
        System.out.println(semana.get(numero));
    }
}
