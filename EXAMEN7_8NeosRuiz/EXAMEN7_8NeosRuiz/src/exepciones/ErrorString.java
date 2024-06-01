package exepciones;

public class ErrorString extends Exception {
	private static final long serialVersionUID = 1L;

	public ErrorString(String message) {
		super("No de permiten campos nulos.");
	}

	@Override
	public String toString() {
		return getMessage();
	}
}