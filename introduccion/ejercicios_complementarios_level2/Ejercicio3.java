import java.util.ArrayList;
import java.util.Collections;

/* Crear una lista que contenga como elementos la numeración de cartas de una baraja
francesa (solo los valores, no figuras). Se deberá cargar el ArrayList (en orden),
imprimir, imprimir en orden inverso (reverse), desordenar (mezclar) el arrayList y
volver a imprimir. */

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> cartas = baraja();
        System.out.println(cartas);
        invertirOrden(cartas);
        aleatorioOrden(cartas);
    }

    static ArrayList<String> baraja() {
        ArrayList<String> cartas = new ArrayList<String>();
        cartas.add("A");
        for (int i=2; i<11; i++) {
            String carta = Integer.toString(i);
            cartas.add(carta);
        }
        cartas.add("J");
        cartas.add("Q");
        cartas.add("K");
        return cartas;
    }
    
    static void invertirOrden(ArrayList<String> cartas) {
        Collections.reverse(cartas);
        System.out.println(cartas);
    }

    static void aleatorioOrden( ArrayList<String> cartas) {
        Collections.shuffle(cartas);
        System.out.println(cartas);
    }
}
