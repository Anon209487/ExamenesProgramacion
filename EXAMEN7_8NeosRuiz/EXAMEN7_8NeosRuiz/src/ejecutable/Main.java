/**
 * 
 */
package ejecutable;

import java.util.Scanner;
import clases.Paciente;
import exepciones.ErrorString;
import exepciones.NumeroFueraDeRango;
import listasobjetos.ListaDePacientes;

/**
 * 
 */
public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int opcion = 0;
		System.out.println("bienvenido" + "\n");
		ListaDePacientes.leeerTxt();
		do {
			opcion = menu();
			switch (opcion) {

			case 1: {
				nuevoPaciente();
				break;
			}
			case 2: {
				listasobjetos.ListaDePacientes.imprimirListaPacientes();
				break;
			}
			case 3: {
				modificarPaciente();
				break;
			}
			case 4: {
				eliminarPaciente();
				break;
			}
			case 5: {
				guardarDatos();
				break;
			}
			case 0: {
				System.out.println("Ha salido Del Programma");
				break;
			}
			default:
				System.err.println("OPCION NO VALIDA");
			}
		} while (opcion != 0);
		scanner.close();
	}

	/**
	 * @param sc
	 * @return
	 */
	private static int menu() {
		int opcion;
		System.out.println("Escoga Opcion: " + "\n");
		System.out.println("1.Añadir paciente.");
		System.out.println("2.Listar pacientes.");
		System.out.println("3.Modificar paciente.");
		System.out.println("4.Eliminar paciente.");
		System.out.println("5.Guardar pacientes.");
		System.out.println("0.Salir.");
		opcion = nextInt();
		return opcion;
	}

	private static void guardarDatos() {
		boolean verificacion = tratamientofichero.Reader.guardarDatos(listasobjetos.ListaDePacientes.listaPacinetes);
		if (verificacion) {
			System.out.println("Datos anyadidios correctamente al fichero.");
		} else {
			System.out.println("Error.");
		}

	}

	private static void modificarPaciente() {

		int opcion;

		Paciente nuevoPaciente;
		boolean verificacion;
		String direccion = "";
		String nombre = "";
		int numero;
		String baja = "";
		System.out.println("Intorduzca Nombre:");
		nombre = nextLine();
		System.out.println("Intorduzca numero:");
		numero = nextInt();
		scanner.nextLine();
		System.out.println("Escoga 2 modificar baja  1 modificar direecion:");
		opcion = nextInt();
		scanner.nextLine();
		switch (opcion) {

		case 1: {
			System.out.println("Intorduzca Nueva Direccion:");
			direccion = nextLine();
			try {
				nuevoPaciente = new Paciente(nombre, numero);
				verificacion = listasobjetos.ListaDePacientes.modificarPacienteDireccion(nuevoPaciente, direccion);
				if (verificacion) {
					System.out.println("Paciente modificado correctamente.");
				} else {
					System.out.println("Error al modificar.");
				}
			} catch (ErrorString e) {

				System.err.println(e.getMessage());
			} catch (NumeroFueraDeRango e) {
				System.err.println(e.getMessage());
			}

			break;
		}
		case 2: {
			System.out.println("Intorduzca Nueva situacion de Baja (introducir SI o NO):");
			baja = nextLine();
			try {
				nuevoPaciente = new Paciente(nombre, numero);
				verificacion = listasobjetos.ListaDePacientes.modidficarPacineteBaja(nuevoPaciente, baja);
				if (verificacion) {
					System.out.println("Paciente modificado correctamente.");
				} else {
					System.out.println("Error al modificar.");
				}
			} catch (ErrorString e) {

				System.err.println(e.getMessage());
			} catch (NumeroFueraDeRango e) {
				System.err.println(e.getMessage());
			}

			break;
		}
		default:
			System.err.println("OPCION NO VALIDA");
		}
	}

	private static void eliminarPaciente() {
		String nombre = "";
		int numero;
		Paciente nuevoPaciente;
		System.out.println("Intorduzca Nombre:");
		nombre = nextLine();
		System.out.println("Intorduzca Numero:");
		numero = nextInt();
		scanner.nextLine();
		try {
			nuevoPaciente = new Paciente(nombre, numero);
			boolean verificacion = listasobjetos.ListaDePacientes.eliminarPacinete(nuevoPaciente);
			if (verificacion) {
				System.out.println("Paciente elimado correctamente.");
			} else {
				System.out.println("Error al eliminar paciente.");
			}
		} catch (ErrorString e) {
			System.err.println(e.getMessage());
		} catch (NumeroFueraDeRango e) {
			System.err.println(e.getMessage());
		}

	}

	private static void nuevoPaciente() {
		boolean verificacion;
		Paciente nuevoPaciente;
		String direccion = "";
		String nombre = "";
		int numero;
		String baja = "";
		System.out.println("Intorduzca Nombre:");
		nombre = nextLine();
		System.out.println("Intorduzca Direccion:");
		direccion = nextLine();
		System.out.println("Intorduzca numero:");
		numero = nextInt();
		scanner.nextLine();
		System.out.println("Intorduzca situacion de Baja (introducir SI o NO):");
		baja = nextLine();

		try {
			nuevoPaciente = new Paciente(nombre, direccion, numero, baja);
			verificacion = listasobjetos.ListaDePacientes.nuevoPaciente(nuevoPaciente);
			if (verificacion) {
				System.out.println("Paciente anyadidio correctamente:");
			} else {
				System.out.println("Error al anyadir paciente:");
			}
		} catch (NumeroFueraDeRango e) {
			System.err.println(e.getMessage());
		} catch (ErrorString e) {
			System.err.println(e.getMessage());
		}

	}

	public static String nextLine() {
		return scanner.nextLine();
	}

	public static int nextInt() {
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;

	}

}
