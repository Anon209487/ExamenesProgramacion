/**
 * 
 */
package tratamientofichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.TreeSet;

import clases.Paciente;
import exepciones.ErrorString;
import exepciones.NumeroFueraDeRango;

public class Reader {
	private final static String FILEPATH = "src/tratamientofichero/pacientes.txt";

	public static TreeSet<Paciente> leeerTxt() {
		TreeSet<Paciente> listaPacietes = new TreeSet<>();
		Paciente paciente;
		String linea = "";
		// Objeto atributos
		String nombre = "";
		String direccion = "";
		int numero;
		String baja = "";
		// Objeto bufferedReader

		BufferedReader reader = null;
		try {
			// Hacemos que el objeto pueda coger los datos de nuestro archivo txt
			reader = new BufferedReader(new FileReader(FILEPATH));
			// Leemos la primera línea
			linea = reader.readLine();
			// Leemos la segunda línea
			linea = reader.readLine();
			// Bucle para ir metiendo en el array datos los datos de los viajes
			while (linea != null) {
				// Array donde introduciremos los datos del viaje
				String[] datos = linea.split(";");
				nombre = datos[0];
				direccion = datos[1];
				numero = Integer.parseInt(datos[2]);
				baja = datos[3];

				try {
					paciente = new Paciente(nombre, direccion, numero, baja);
					listaPacietes.add(paciente);
				} catch (NumeroFueraDeRango | ErrorString e) {
					System.err.println("Error al Leer los datos: " + e.getMessage());
				}
				linea = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error IOException: " + e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println("Error al Leer los datos: " + e.getMessage());
			}
		}
		return listaPacietes;
	}

	public static boolean guardarDatos(TreeSet<Paciente> listaPacietes) {
		boolean datosGuardados = false;
		String insetar = "nombre;dirección;teléfono;baja";
		try {
			File archivo = new File(FILEPATH);
			// no me funciona el BufferedReadersi no pongo la dirrecion completa
			FileWriter fw;
			if (archivo.exists()) {
				fw = new FileWriter(archivo, false);
			} else {
				fw = new FileWriter(archivo);
			}
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(insetar);
			bw.newLine();
			for (Paciente P : listaPacietes) {
				insetar = P.getNombre() + ";" + P.getDireccion() + ";" + P.getNumero() + ";" + P.getBaja();
				bw.write(insetar);
				bw.newLine();
			}
			bw.close();
			datosGuardados = true;
		} catch (IOException e) {
			System.err.println("Error al guardar los datos: " + e.getMessage());
		}
		return datosGuardados;
	}
}
