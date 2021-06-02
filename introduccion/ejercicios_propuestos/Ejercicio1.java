import java.util.Scanner;

/* Crear una función que realice la suma de 2 números dados. */

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero1 = sc.nextInt();
		int numero2 = sc.nextInt();
		sumaDosNumeros(numero1, numero2);
		sc.close();
	}

	static void sumaDosNumeros(int numero1, int numero2) {
		int suma = numero1 + numero2;
		System.out.println(suma);
	}
}