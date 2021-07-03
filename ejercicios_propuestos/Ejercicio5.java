import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Ejercicio5 {
    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        System.out.println("---------");
        creaPersona(listaPersonas);
        String letra = "s".toUpperCase();
        System.out.println("Personas cuyo apellido comienza con " + letra);
        empiezaCon(listaPersonas, letra);
        System.out.println("---------");
        System.out.println("El/La más viejo es: " + getMasViejo(listaPersonas));
        System.out.println("El/La más joven es: " + getMasJoven(listaPersonas));
        System.out.println("El/La que más gana es: " + getMenorSueldo(listaPersonas));
        System.out.println("El/La que menos gana es: " + getMayorSueldo(listaPersonas));
        System.out.println("Ordenado alfaveticamente:");
        System.out.println(getOrdenABC(listaPersonas));
    }
    
    // Lee el archivo Ejercicio5.txt y crea una instancia de Persona por cada linea
    static void creaPersona(List<Persona> listaPersonas) {
        String archivo = "Ejercicio5.txt";
        try (Stream<String> stream = Files.lines(Paths.get(archivo))){
            stream.forEach((e) -> {
                String[] lista = e.split(",");
                String nombre = lista[0];
                String apellido = lista[1];
                String fechaNacimiento = lista[2];
                String sueldo = lista[3];
                Persona persona = new Persona(nombre, apellido, fechaNacimiento, sueldo);
                listaPersonas.add(persona);
            });
        } catch (Exception e) {
            System.out.println("Ocurrió un error.!!" + e.getMessage());
        }
    }

    // Muestra las personas cuyo apellido comience con "letra"
    static void empiezaCon(List<Persona> listaPersonas, String letra) {
        listaPersonas.forEach((e) -> {
            if (e.apellido.startsWith(letra)) {
                System.out.println(e);
            }
        });
    }

    // Muestra la persona con mayor edad
    static Persona getMasViejo(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            int comp = 0;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp < listaPersonas.get(i).edad()) {
                    comp = listaPersonas.get(i).edad();
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).edad() == comp) {
                    System.out.println(listaPersonas.get(i).edad());
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }

    // Muestra la persona con menor edad
    static Persona getMasJoven(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            int comp = listaPersonas.get(0).edad();
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp > listaPersonas.get(i).edad()) {
                    comp = listaPersonas.get(i).edad();
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).edad() == comp) {
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }

    // Muestra la persona que gana más
    static Persona getMayorSueldo(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            BigDecimal comp = listaPersonas.get(0).sueldo;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp.compareTo(listaPersonas.get(i).sueldo) == -1 ) {
                    comp = listaPersonas.get(i).sueldo;
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).sueldo == comp) {
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }
    
    // Muestra la persona que gana menos
    static Persona getMenorSueldo(List<Persona> listaPersonas) {
        if (listaPersonas.size() != 0) {
            BigDecimal comp = listaPersonas.get(0).sueldo;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (comp.compareTo(listaPersonas.get(i).sueldo) == 1 ) {
                    comp = listaPersonas.get(i).sueldo;
                }
            }
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).sueldo == comp) {
                    return listaPersonas.get(i);
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
        return null;
    }

    // Ordena alfaveticamente la lista de personas
    static List<Persona> getOrdenABC(List<Persona> listaPersonas) {
        // Collections.sort(lista);
        listaPersonas.sort((o1, o2) -> o1.nombre.compareTo(o2.nombre));
        return listaPersonas;
    }


    static class Persona {
        private String nombre;
        private String apellido;
        private LocalDate fechaNacimiento;
        private BigDecimal sueldo;

        public Persona(String nombre, String apellido, String fechaNacimiento, String sueldo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = toFecha(fechaNacimiento);
            // this.sueldo = toSueldo(sueldo);
            this.sueldo = new BigDecimal(sueldo);
        }

        private LocalDate toFecha(String fechaNacimiento) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);
            return fecha;
        }

        private int edad() {
            int diferencia = (int) ChronoUnit.DAYS.between(this.fechaNacimiento, LocalDate.now());
            return diferencia/365;
        }

        @Override
        public String toString() {
            return this.nombre + " " + this.apellido + ": $" + this.sueldo;
        }
    }
}