import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Dados 2 ArrayList que contienen horas-trabajadas (array1) y valor-por-hora(array2)
del resumen de carga de horas semanal de un empleado. Se debe generar otra lista que
contenga los totales y luego imprimir el total final a cobrar. */

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> horasTrabajadas = horasTrabajadas(sc);
        List<Integer> valorHora = valorHora(sc);
        List<Integer> totales = totales(horasTrabajadas, valorHora);
        totalFinal(totales);
        sc.close();
    }

    static List<Integer> horasTrabajadas(Scanner sc) {
        List<Integer> listaHoras = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int cantidad = sc.nextInt();
            listaHoras.add(cantidad);
        }
        return listaHoras;
    }

    static List<Integer> valorHora(Scanner sc) {
        List<Integer> listaValoes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int cantidad = sc.nextInt();
            listaValoes.add(cantidad);
        }
        return listaValoes;
    }

    static List<Integer> totales(List<Integer> horasTrabajadas, List<Integer> valorHora) {
        List<Integer> listaTotales = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int totalDia = horasTrabajadas.get(i) * valorHora.get(i);
            listaTotales.add(totalDia);
        }
        System.out.println(listaTotales);
        return listaTotales;
    }

    static int totalFinal(List<Integer> totales) {
        int total = 0;
        for (int valor : totales) {
            total += valor;
        }
        System.out.println("Total Final: " + total);
        return total;
    }
}
