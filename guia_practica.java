import java.util.HashMap;
import java.util.Scanner;


/* Ejercicio 1: Realizar un programa que realice la impresión por consola del siguiente
mensaje: Hola Informatorio 2020!! */

class Ejercicio1 {
    public static void main(String[] args) {
        String saludo = "Hola Informatorio 2020!!";
        saludar(saludo);
    }

    static void saludar(String texto) {
        System.out.println(texto);
    }
}


/* Ejercicio 2: Realizar un programa que al ejecutar se pueda ingresar 3 numeros enteros,
para luego imprimirlos por pantalla de la siguiente manera:
El primer nro ingresado es: 4
El segundo nro ingresado es: 5
El tercer nro ingresado es: 6
*/

class Ejercicio2 {
    public static void main(String[] args) {
        ingresaNumeros();
    }

    // Lee números ingresados y los imprime por consola
    static public void ingresaNumeros() {
        // Instancia de Scaner
        Scanner sc = new Scanner(System.in);
        // Entrada de datos
        System.out.println("Ingrese el primer número entero: ");
        int numero1 = sc.nextInt();
        System.out.println("Ingrese el segundo número entero: ");
        int numero2 = sc.nextInt();
        System.out.println("Ingrese el tercer número entero: ");
        int numero3 = sc.nextInt();
        // Cierre de instancia Scaner
        sc.close();

        imprimirNumeros(numero1, numero2, numero3);
    }

    // Impreción de valores ingresados
    static void imprimirNumeros(int primero, int segundo, int tercero) {
        System.out.println("El primer nro ingresado es: " + primero);
        System.out.println("El segundo nro ingresado es: " + segundo);
        System.out.println("El tercer nro ingresado es: " + tercero);
    }
}


/* Ejercicio 3: Tendremos un sistema que debe clasificar el resultado de una evaluación.
Como dato de entrada tendremos un entero y como resultado un String de la clasificación de
la siguiente forma:

Rango               Clasificación
93-100              Exceclente
85-92               Sobresaliente
75-84               Distinguido
60-74               Bueno
00-59               Desaprobado
*/

class Ejercicio3 {
    public static void main(String[] args) {
        clasificacion();    
    }

    // Clacifica notas
    public static void clasificacion() {
        int valor = nota();
        // Clasificación de notas
        if (valor >= 0 && valor <= 59) {
            System.out.println("Desaprobado");
        } else if (valor <= 74) {
            System.out.println("Bueno");
        } else if (valor <= 84) {
            System.out.println("Distinguido");
        } else if (valor <= 92) {
            System.out.println("Sobresaliente");
        } else {
            System.out.println("Excelente");
        }
    }

    // Lectura de datos ingresados por consola
    static int nota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nota: ");
        int entero = sc.nextInt();
        sc.close();
        return entero;
    }
}


/* Ejercicio 4: Realizar un programa que dado un número de entrada entre 1 a 7, nos devuelva
el dia de la semana de la siguiente forma:

Número              Día
1                   Domingo
2                   Lunes
3                   Martes
4                   Miércoles
5                   Jueves
6                   Viernes
7                   Sábado
*/

class Ejercicio4 {
    public static void main(String[] args) {
        int numero = numeroDia();
        nombreDia(numero);
    }

    // Lee un número ingresado por consola
    static int numeroDia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número del 1 al 7: ");
        int numero = sc.nextInt();
        sc.close();
        return numero;
    }

    // Muestra el día de la semana correspondiente al número ingresado
    static void nombreDia(int numero) {
        HashMap<Integer, String> semana = new HashMap<Integer, String>();
        semana.put(1, "Domingo");
        semana.put(2, "Lunes");
        semana.put(3, "Martes");
        semana.put(4, "Miercoles");
        semana.put(5, "Jueves");
        semana.put(6, "Viernes");
        semana.put(7, "Sabado");
        System.out.println(semana.get(numero));
    }
}


/* Ejercicio 5: Desarrollar un programa que dado un número entero ingresado, nos retorne los
valores de ese número multiplicado por 1, 2, 3, … y 10. */

class Ejercicio5 {
    public static void main(String[] args) {
        int valor = ingresaNumero();
        multiplicar(valor);
    }

    // Multiplica un número por los valores de un rango del 1 al 10 inclusive y los imprime por pantalla
    static void multiplicar(int numero) {
        for (int i = 1; i < 11; i++) {
            int resultado = numero * i;
            String formato = "%d*%d = %d";
            String mensaje = String.format(formato, numero, i, resultado);
            System.out.println(mensaje);
        }
    }

    // Lee un valor ingresado por consola
    static int ingresaNumero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int numero = sc.nextInt();
        sc.close();
        System.out.println("--------");
        return numero;
    }
}


/* Ejercicio 6: Debemos realizar un programa que nos realizará una pregunta si queremos realizar
una operación dada o si deseamos salir/terminar el programa.
Utilizaremos en este caso una simple operación que nos pide un número y luego lo imprime. */

class Ejercicio6 {
    public static void main(String[] args) {
        operacion();
    }

    // Ciclo de elecciones
    static void operacion() {
        Scanner sc = new Scanner(System.in);
        int comienzo = 1;
        while (comienzo != 2) {
            // Menú de opciones
            System.out.println("Que desea hacer.?");
            System.out.println("1- Algo");
            System.out.println("2- Otra cosa");
            int eleccion = sc.nextInt();
            System.out.println("---------");
            // Opción elejida
            System.out.println("Su eleccion fue la número " + eleccion);
            System.out.println("---------");
            // Continuar/Salir
            System.out.println("1- Continuar.?");
            System.out.println("2- Salir");
            comienzo = sc.nextInt();
        }
        sc.close();
    }
}


