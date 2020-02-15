package customExceptions;

public class IncorrectNameInputException extends Exception {
	public IncorrectNameInputException() {
		super("The name that you type cannot have numbers.");
	}
}
