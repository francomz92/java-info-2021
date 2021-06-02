import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/* Dado un archivo de texto (alumnos.txt), crear una función que lea
todos los nombres de los alumnos y los imprima por pantalla. */

public class Ejercicio3 {
    public static void main(String[] args) {
        leerNombres();
    }

    static void leerNombres() {
        String archivo = "alumnos.txt";
        try (Stream<String> stream = Files.lines(Paths.get(archivo))){
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
