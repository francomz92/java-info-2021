/* Realizar una función que calcule el factorial de un número dado. */

public class Ejercicio2 {
	public static void main(String[] args) {
		
	}

	static int factorial(int numero) {
		if (numero == 0) {
			return 1;
		}
		return numero * factorial(numero -1);
	}
}