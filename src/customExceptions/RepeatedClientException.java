package customExceptions;

public class RepeatedClientException extends Exception {
	
	public RepeatedClientException(String a) {
		super("The client" + a + " " + "is already registered");
	}

}
