/**
 * 
 */
package examen;

import java.util.Random;

/**
 * 
 */
public class ClaseAbecedario {

	public static char[][] abecedario = { { 'a', 'j', 'r' }, { 'b', 'k', 's' }, { 'c', 'l', 't' }, { 'd', 'm', 'u' },
			{ 'e', 'n', 'v' }, { 'f', 'ñ', 'w' }, { 'g', 'o', 'x' }, { 'h', 'p', 'i' }, { '1', 'q', 'z' } };

	private String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };
	private String fraseReal = "";
	private String fraseCodificada = "";

	/**
	 * @return the fraseReal
	 */
	public String getFraseReal() {
		return fraseReal;
	}

	public String[] getFrases() {
		return frases;
	}

	/**
	 * @return the fraseCodificada
	 */
	public String getFraseCodificada() {
		return fraseCodificada;
	}

	/**
	 * @param fraseCodificada the fraseCodificada to set
	 */
	public void setFraseCodificada(String fraseCodificada) {
		this.fraseCodificada = fraseCodificada;
	}

	public static void desordenaTablaOrdenadamente() {
		Random random = new Random();
		int i = 0;
		for (int j : random.ints(abecedario.length, 0, abecedario.length).toArray()) {
			swap(abecedario, i++, j);
		}
	}

	protected static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void elegirFrase() {
		int numeroAleatorio = (int) (Math.random() * 5);
		this.fraseReal = frases[numeroAleatorio];
	}

	public void codificaClase() {
		char[] letras = this.fraseReal.toCharArray();
		for (int a = 0; a < letras.length; a++) {

			for (int i = 0; i < abecedario.length; ++i) {
				for (int j = 0; j < abecedario[i].length; ++j) {
					if (abecedario[i][j] == letras[a]) {
						this.fraseCodificada += i + "" + j + " ";
					}

				}
			}
		}
	}

	public boolean compruebaCodigo(String cod, String letra) {
		boolean compruebaCodigo;
		char letraChar = letra.charAt(0);
		int numEntero = Character.getNumericValue(cod.charAt(0));
		int numEntero2 = Character.getNumericValue(cod.charAt(1));
		if (abecedario[numEntero][numEntero2] == letraChar) {
			this.fraseCodificada = this.fraseCodificada.replace(numEntero + "" + numEntero2, letra);
			compruebaCodigo = true;
		} else {
			compruebaCodigo = false;
		}
		return compruebaCodigo;

	}

	public boolean sonIguales() {
		boolean sonIguales;
		String fraseCodificada = this.fraseCodificada.replace(" ", "");
		String fraseReal = this.fraseReal.replace(" ", "");
		if (fraseCodificada.equals(fraseReal)) {
			sonIguales = false;

		} else {
			sonIguales = true;
		}
		return sonIguales;
	}
}