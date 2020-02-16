package model;

public class Turn {

	public static final int PENDING = 1;
	public static final int ATTENDING = 2;
	public static final int NOT_PRESENTED = 3;
	public static final int ATTENDED = 4;
	private String identificator;
	private int status;
	private Client client;

	/**
	 * Description: This it the constructor method of TurnControl class. <br>
	 * 
	 * @param identificator It is the String that represents the turn.
	 * @param status        It is turn's status, it could be pending, attending, not
	 *                      presented or attended.
	 * @param client        it is the client that we will assigned to the turn.
	 */
	public Turn(String identificator, int status, Client client) {
		this.identificator = identificator;
		this.status = status;
		this.client = client;
	}

	/**
	 * Description: This method gives us the client the turn has assigned. <br>
	 * 
	 * @return the client assigned to that turn.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Description: This method change the client assigned. <br>
	 * <b>post: </b> The client had been changed.
	 * 
	 * @param client is a Client that sets the client assigned.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Description: This method gives us turn's identificator. <br>
	 * 
	 * @return turn's identificator.
	 */
	public String getIdentificator() {
		return identificator;
	}

	/**
	 * Description: This method change the identificator assigned. <br>
	 * <b>post: </b> The identificator had been changed.
	 * 
	 * @param identificator is a String that sets the identificator assigned.
	 */
	public void setIdentificator(String identificator) {
		this.identificator = identificator;
	}

	/**
	 * Description: This method gives us turn's status. <br>
	 * 
	 * @return turn's status.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Description: This method change turn's status. <br>
	 * <b>post: </b> The status had changed.
	 * 
	 * @param status is an int that sets turn's status..
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}
