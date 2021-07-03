import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* Teniendo una lista de objetos Empleado, cargar la misma en un archivo empleado.txt. */

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        creaEmpleado(listaEmpleados);
        cargaEmpleados(listaEmpleados);
    }

    static class Empleado {
        private String nombreApellido;

        public Empleado(String nombreApellido) {
            this.nombreApellido = nombreApellido;
        }

        @Override
        public String toString() {
            return this.nombreApellido;
        }
    }

    static void creaEmpleado(List<Empleado> listaEmpleados) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 -> Nuevo empleado\n0 -> Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 0) {
                break;
            }
            else if (opcion == 1) {
                System.out.println("Ingrese el nombre completo del empleado:");
                String nombre = sc.nextLine();
                Empleado emp = new Empleado(nombre);
                listaEmpleados.add(emp);
            }
        }
        sc.close();
    }

    static void cargaEmpleados(List<Empleado> listaEmpleados) {
        try {
            FileWriter archivo = new FileWriter("empleado.txt");
            for (Empleado empleado : listaEmpleados) {
                archivo.write(empleado.toString() + "\n");
            }
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
