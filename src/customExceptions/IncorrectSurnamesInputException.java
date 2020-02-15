package customExceptions;

public class IncorrectSurnamesInputException extends Exception {
	public IncorrectSurnamesInputException() {
		super("The name that you type cannot have numbers.");
	}
}
