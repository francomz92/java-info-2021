import java.util.Scanner;

/* Solicitar por consola el nombre del usuario e imprimir por pantalla el siguiente
mensaje “HOLA {USUARIO}!!!” */

public class Ejercicio1 {
    public static void main(String[] args) {
        saludar();
    }
    
    // Imprime un saludo al usuario ingresado por consola
    static void saludar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String saludo = sc.nextLine();
        sc.close();
        String mensaje = String.format("HOLA %s!!!", saludo);
        System.out.println(mensaje);
    }
}