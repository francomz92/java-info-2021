import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Cargar un arrayList con 12 nombres de estudiantes (String), luego separarlos
en 3 cursos (3 arrayList) e imprimir dichos cursos. */

public class Ejercicio4 {
    public static void main(String[] args) {
        List<String> estudiantes = estudiantes();
        System.out.println("--------");
        clasificacion(estudiantes);
    }
    
    static List<String> estudiantes() {
        Scanner sc = new Scanner(System.in);
        List<String> listaEstudiantes = new ArrayList<>();
        for (int i=0; i< 12; i++) {
            System.out.println("Ingresa el nombre del estudiante:");
            String estudiante = sc.nextLine();
            listaEstudiantes.add(estudiante);
        }
        sc.close();
        return listaEstudiantes;
    }
    
    // Reparte a los alumnos en diferentes cursos de manera equitativa y muestra la matrícula de cada curso
    static void clasificacion(List<String> estudiantes) {
        Collections.shuffle(estudiantes);
        List<String> curso1 = estudiantes.subList(0, 4);
        List<String> curso2 = estudiantes.subList(4, 8);
        List<String> curso3 = estudiantes.subList(8, 12);

        System.out.println("Curso 1: " + curso1);
        System.out.println("Curso 2: " + curso2);
        System.out.println("Curso 3: " + curso3);
    }
}
