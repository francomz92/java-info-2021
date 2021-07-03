import java.util.ArrayList;
import java.util.Scanner;

/* Crear un ArrayList, agregar 5 números enteros. Luego, agregar un número entero
al principio de la lista y otro al final. Por último, iterar e imprimir los
elementos de la lista y el tamaño de la misma (antes y después de agregar a en la
primera y última posición). */


public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = listaNumeros(sc);
        agregarAlInicio(sc, numeros);
        agregarAlFinal(sc, numeros);
        sc.close();
    }
    
    static ArrayList<Integer> listaNumeros(Scanner sc) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for (int i=0; i<5; i++) {
            System.out.println("Ingrese un número entero a la lista");
            int numero = sc.nextInt();
            numeros.add(numero);
        }
        return numeros;
    }
    
    static void agregarAlInicio(Scanner sc, ArrayList<Integer> numeros) {
        System.out.println("Ingrese un número al inicio de la lista");
        int numero = sc.nextInt();
        numeros.add(0, numero);
        System.out.println(numeros);
    }
    
    static void agregarAlFinal(Scanner sc, ArrayList<Integer> numeros) {
        System.out.println("Ingrese un número al final de la lista");
        int numero = sc.nextInt();
        numeros.add(numero);
        System.out.println(numeros);
    }
}