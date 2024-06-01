/**
 * 
 */
package listasobjetos;

import java.util.TreeSet;

import clases.Paciente;
import exepciones.ErrorString;
import exepciones.NumeroFueraDeRango;

/**
 * 
 */
public class ListaDePacientes {
	public static TreeSet<Paciente> listaPacinetes = new TreeSet<>();

	public static void leeerTxt() {
		listaPacinetes = tratamientofichero.Reader.leeerTxt();

	}

	public static void imprimirListaPacientes() {
		System.out.println("Lista completa de pacientes.");
		for (Paciente paciente : listaPacinetes) {
			System.out.println(paciente);
		}
	}

	public static boolean nuevoPaciente(Paciente nuevoPaciente) {
		boolean nuevoPacienteAnyadido = true;
		for (Paciente paciente : listaPacinetes) {
			if (paciente.equals(nuevoPaciente)) {
				nuevoPacienteAnyadido = false;
			}
		}
		if (nuevoPacienteAnyadido) {
			listaPacinetes.add(nuevoPaciente);

		}
		return nuevoPacienteAnyadido;
	}

	public static boolean modificarPacienteDireccion(Paciente datosPaciente, String direccion)
			throws ErrorString, NumeroFueraDeRango {
		boolean pacientemModificado = false;
		if (listaPacinetes.contains(datosPaciente)) {
			listaPacinetes.remove(datosPaciente);
			datosPaciente.setDireccion(direccion);
			listaPacinetes.add(datosPaciente);
			pacientemModificado = true;
		}
		return pacientemModificado;
	}

	public static boolean modidficarPacineteBaja(Paciente datosPaciente, String baja)
			throws ErrorString, NumeroFueraDeRango {
		boolean pacientemModificado = false;
		if (listaPacinetes.contains(datosPaciente)) {
			listaPacinetes.remove(datosPaciente);
			datosPaciente.setBaja(baja);
			listaPacinetes.add(datosPaciente);
			pacientemModificado = true;
		}

		return pacientemModificado;
	}

	public static boolean eliminarPacinete(Paciente datosPaciente) {
		boolean pacientemEliminado = false;
		if (listaPacinetes.remove(datosPaciente)) {
			pacientemEliminado = true;

		}
		return pacientemEliminado;
	}

}
