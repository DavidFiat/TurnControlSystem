package model;

public class Turn {

	public static final int PENDING = 1;
	public static final int ATTENDING = 2;
	public static final int NOT_PRESENTED = 3;
	public static final int ATTENDED = 4;
	private String identificator;
	private int status;
	private Client client;
	private String time;

	public Turn(String identificator, int status, String time, Client client) {
		this.identificator = identificator;
		this.status = status;
		this.time = time;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getIdentificator() {
		return identificator;
	}

	public void setIdentificator(String identificator) {
		this.identificator = identificator;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
