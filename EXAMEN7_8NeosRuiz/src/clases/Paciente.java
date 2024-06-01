/**
 * 
 */
package clases;

import java.util.Objects;

import exepciones.ErrorString;
import exepciones.NumeroFueraDeRango;

/**
 * Clase paciente que representa los datos de un paciente implementa un intrfaz
 * comparable
 */
public class Paciente implements Comparable<Object> {
	/*
	 * Cadena nombre que representa el nombre del pacientey sirve como primer id
	 */
	private String nombre = "";
	/*
	 * Cadena dieccion que representa la dirrecion de la vivienda
	 */
	private String direccion = "";
	/**
	 * representa valor numerico del telefono del paciente y actua como segunda
	 * clave
	 */
	private int numero;
	/*
	 * representa si el pacinte se ha dado de baja del hospital
	 */
	private boolean baja = false;

	/*
	 * constructor con dos parametros paracomparar y para hacer busquedas en el
	 * arrayList lanza errores en caso de valores incorrectos
	 */
	public Paciente(String nombre, int numero) throws ErrorString, NumeroFueraDeRango {
		if (nombre != null && !nombre.equals("")) {
			this.nombre = nombre;
		} else {
			throw new ErrorString("Error en el constructor 1:");
		}
		if (numero >= 100000000 && numero <= 999999999) {
			this.numero = numero;
		} else {
			throw new NumeroFueraDeRango("Error en el constructor 1:");
		}
	}

	/*
	 * contructor con todos los datos con lanza errores en caso de valores
	 * incorrectos
	 */
	public Paciente(String nombre, String direccion, int numero, String baja) throws NumeroFueraDeRango, ErrorString {
		this(nombre, numero);
		if (direccion != null && !direccion.equals("")) {
			this.direccion = direccion;
		} else {
			throw new ErrorString("Error en el constructor 2:");
		}

		if (baja.equalsIgnoreCase("Si")) {
			this.baja = true;
		} else if (baja.equalsIgnoreCase("NO")) {
			this.baja = false;
		}

	}

	/*
	 * devuelve la dirrecion
	 * 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * modifica la dirrecion
	 * 
	 * @param direccion
	 * @throws ErrorString
	 */
	public void setDireccion(String direccion) throws ErrorString {
		if (direccion != null && !direccion.equals("")) {
			this.direccion = direccion;
		} else {
			throw new ErrorString("Error setter Dirrecionr :");
		}
	}

	/**
	 * devuelve el numero
	 * 
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * 
	 * @param numero
	 * @throws NumeroFueraDeRango
	 */
	public void setNumero(int numero) throws NumeroFueraDeRango {
		if (numero > 100000000 && numero < 999999999) {
			this.numero = numero;
		} else {
			throw new NumeroFueraDeRango("Error setter Numero: ");

		}
	}

	/**
	 * devuelve el nombre
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * devuelve la baja se encarga de pasar el String a boolean
	 * 
	 * @return
	 */
	public String getBaja() {
		String baja = "";
		if (this.baja) {
			baja = "SI";
		} else {
			baja = "NO";
		}
		return baja;

	}

	/**
	 * modifica la baja
	 * 
	 * @param baja
	 */
	public void setBaja(String baja) {
		if (baja.equalsIgnoreCase("SI")) {
			this.baja = true;
		} else if (baja.equalsIgnoreCase("NO")) {
			this.baja = false;
		}
	}

	/*
	 * metodo toString encargado de imprimir el objeto modifica ekl bollean para
	 * mandar un string
	 * 
	 * @return res
	 */
	@Override
	public String toString() {
		String bajaString = "";
		String res = "";
		if (baja) {
			bajaString = "SI";
		} else {
			bajaString = "NO";
		}
		res = "nombre: " + nombre + "\n";
		res += "direccion: " + direccion + "\n";
		res += "numero: " + numero + "\n";
		res += "baja: " + bajaString + "\n";
		return res;
	}

	/**
	 * no se que hace pero he he echudado que Amaro lo iba a dejar asi que lo dejo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(baja, direccion, nombre, numero);
	}

	/**
	 * recive un objeto de tipo object se encarga de comparar si dps objetos son
	 * iguales en este caso pr eñ nombre y el nuemro
	 * 
	 * @param obj
	 * @return res
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		Paciente pacienteComparacion = (Paciente) obj;
		if (nombre.equals(pacienteComparacion.nombre) && numero == pacienteComparacion.numero) {
			res = true;
		}
		return res;
	}

	/**
	 * se encarga de comparar dos objetos por el nombre y numero de telefono
	 * devuelveo si son iguale 1 si es mayor y menos 1 si es menor
	 */
	public int compareTo(Object obj) {
		int res = 0;
		int comparedResult;
		Paciente per = (Paciente) obj;
		comparedResult = this.nombre.compareTo(per.nombre);
		if (comparedResult < 0) {
			res = -1;
		} else if (comparedResult > 0) {
			res = 1;
		} else {
			if (this.numero < per.numero) {
				res = -1;
			} else if (this.numero > per.numero) {
				res = 1;
			}
		}
		return res;
	}
}
