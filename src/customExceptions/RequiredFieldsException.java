package customExceptions;

public class RequiredFieldsException extends Exception {
	public RequiredFieldsException() {
		super("You must type: type of document, number of document, names and surnames. Those are obligatory fields");
	}
}
