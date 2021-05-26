import java.util.ArrayList;
import java.util.Scanner;

/* Crear un ArrayList y cargarlo con tus ciudades favoritas de Argentina,
luego imprimir por pantalla el ranking */


public class Ejercicio1 {
    public static void main(String[] args) {
        listaCiudades();
    }

    static void listaCiudades() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ciudades = new ArrayList<String>();
        boolean inicio = true;
        while (inicio) {
            System.out.println("Ingrese el nombre de una ciudad o presione Enter para salir:");
            String ciudad = sc.nextLine();
            if (ciudad.length() == 0) {
                inicio = false;
            }
            ciudades.add(ciudad);
        }
        sc.close();
        String mensaje = "#1 - %s";
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudades.get(i).length() != 0) {
                System.out.println(String.format(mensaje, ciudades.get(i)));
            }
        }
    }
}