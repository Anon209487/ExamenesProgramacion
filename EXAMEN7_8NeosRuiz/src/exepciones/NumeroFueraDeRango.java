package exepciones;

public class NumeroFueraDeRango extends Exception {
	private static final long serialVersionUID = 1L;

	public NumeroFueraDeRango(String message) {
		super("El numero debe tener 6 cifras.");
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
