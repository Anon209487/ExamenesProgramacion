/**
 * 
 */
package examen;

import java.util.Scanner;

/**
 * 
 */
public class Ejecutasble {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClaseAbecedario nuevoJuego = new ClaseAbecedario();
		iniciarJuego(nuevoJuego);
		do {
			introducirCodigo(nuevoJuego);
		} while (nuevoJuego.sonIguales());
		System.out.println("Ha ganado");
		scanner.close();
	}

	/**
	 * @param nuevoJuego
	 */
	private static void introducirCodigo(ClaseAbecedario nuevoJuego) {
		scanner = new Scanner(System.in);
		String codigo = "";
		String letra = "";
		System.out.println(nuevoJuego.getFraseCodificada() + "\n");
		System.out.println("Nuevo codigo:");
		codigo = scanner.nextLine();
		System.out.println("Nueva letra:");
		letra = scanner.nextLine();
		boolean acierto = nuevoJuego.compruebaCodigo(codigo, letra);
		if (acierto) {
			System.out.println("Ha acertado." + "\n");
		} else {
			System.out.println("No ha acertado." + "\n");
		}

	}

	/**
	 * @param nuevoJuego
	 */
	private static void iniciarJuego(ClaseAbecedario nuevoJuego) {
		ClaseAbecedario.desordenaTablaOrdenadamente();
		nuevoJuego.elegirFrase();
		nuevoJuego.codificaClase();
	}

}
