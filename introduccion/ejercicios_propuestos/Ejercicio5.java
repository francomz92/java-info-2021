import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println("---------");
        creaPersona();
        String letra = "s".toUpperCase();
        System.out.println("Personas cuyo apellido comienza con " + letra);
        Persona.empiezaCon(letra);
        System.out.println("---------");
        System.out.println("El/La más viejo es: ");
        Persona.mayor();
        System.out.println("El/La más joven es: ");
        Persona.menor();
        System.out.println("El/La que más gana es: ");
        Persona.menorSueldo();
        System.out.println("El/La que menos gana es: ");
        Persona.mayorSueldo();
        System.out.println("Ordenado:");
        Persona.ordenABC();
    }
    
    // Lee el archivo Ejercicio5.txt y crea una instancia de Persona por cada linea
    static void creaPersona() {
        String archivo = "Ejercicio5.txt";
        try (Stream<String> stream = Files.lines(Paths.get(archivo))){
            stream.forEach((e) -> {
                String[] lista = e.split(",");
                String nombre = lista[0];
                String apellido = lista[1];
                String fechaNacimiento = lista[2];
                String sueldo = lista[3];
                Persona persona = new Persona(nombre, apellido, fechaNacimiento, sueldo);
                // System.out.println(persona);
            });
        } catch (Exception e) {
            System.out.println("Ocurrió un error.!!" + e.getMessage());
        }
    }

    static class Persona {
        static List<Persona> listaPersonas = new ArrayList<>();
        String nombre;
        String apellido;
        LocalDate fechaNacimiento;
        BigDecimal sueldo;

        public Persona(String nombre, String apellido, String fechaNacimiento, String sueldo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = toFecha(fechaNacimiento);
            this.sueldo = toSueldo(sueldo);
            listar();
        }

        static LocalDate toFecha(String fechaNacimiento) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);
            return fecha;
        }

        static BigDecimal toSueldo(String sueldo) {
            BigDecimal monto = new BigDecimal(sueldo);
            return monto;
        }

        // Agrega instancia a la lista de Personas
        private void listar() {
            listaPersonas.add(this);
        }

        // Muestra las personas cuyo apellido comience con "letra"
        public static void empiezaCon(String letra) {
            listaPersonas.forEach((e) -> {
                if (e.apellido.startsWith(letra)) {
                    System.out.println(e);
                }
            });
        }

        private int edad() {
            int edad = LocalDate.now().getYear() - this.fechaNacimiento.getYear();
            return edad;
        }

        // Muestra la persona con mayor edad
        public static void mayor() {
            if (listaPersonas.size() != 0) {
                int comp = 0;
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (comp < listaPersonas.get(i).edad()) {
                        comp = listaPersonas.get(i).edad();
                    }
                }
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).edad() == comp) {
                        System.out.println(listaPersonas.get(i));
                    }
                }
            }
            else {
                System.out.println("Archivo vacío.!!");
            }
        }

        // Muestra la persona con menor edad
        public static void menor() {
            if (listaPersonas.size() != 0) {
                int comp = listaPersonas.get(0).edad();
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (comp > listaPersonas.get(i).edad()) {
                        comp = listaPersonas.get(i).edad();
                    }
                }
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).edad() == comp) {
                        System.out.println(listaPersonas.get(i));
                    }
                }
            }
            else {
                System.out.println("Archivo vacío.!!");
            }
        }

        // Muestra la persona que gana más
        public static void mayorSueldo() {
            if (listaPersonas.size() != 0) {
                BigDecimal comp = listaPersonas.get(0).sueldo;
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (comp.compareTo(listaPersonas.get(i).sueldo) == -1 ) {
                        comp = listaPersonas.get(i).sueldo;
                    }
                }
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).sueldo == comp) {
                        System.out.println(listaPersonas.get(i));
                    }
                }
            }
            else {
                System.out.println("Archivo vacío.!!");
            }
        }
        
        // Muestra la persona que gana menos
        public static void menorSueldo() {
            if (listaPersonas.size() != 0) {
                BigDecimal comp = listaPersonas.get(0).sueldo;
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (comp.compareTo(listaPersonas.get(i).sueldo) == 1 ) {
                        comp = listaPersonas.get(i).sueldo;
                    }
                }
                for (int i = 0; i < listaPersonas.size(); i++) {
                    if (listaPersonas.get(i).sueldo == comp) {
                        System.out.println(listaPersonas.get(i));
                    }
                }
            }
            else {
                System.out.println("Archivo vacío.!!");
            }
        }

        // Ordena alfaveticamente la lista de personas
        public static void ordenABC() {
            // Collections.sort(lista);
            listaPersonas.sort((o1, o2) -> o1.nombre.compareTo(o2.nombre));
            System.out.println(listaPersonas);
        }

        @Override
        public String toString() {
            return this.nombre + " " + this.apellido + ": $" + this.sueldo;
        }
    }
}