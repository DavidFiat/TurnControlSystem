package model;

import java.util.ArrayList;

import customExceptions.RepeatedClientException;
import customExceptions.RequiredFieldsException;

public class TurnControl {

	private ArrayList<Client> clients;
	private ArrayList<Turn> turns;
	private char currentLetter;
	private int currentNumber;

	public TurnControl() {
		clients = new ArrayList<Client>();
		turns = new ArrayList<Turn>();
		currentLetter = 65;
		currentNumber = 0;

	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Turn> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}

	public Client searchClient(String ID, String typeOfDocument) {
		Client a = null;
		for (Client s : clients) {
			if (s.getID().equals(ID) && s.getTypeOfDocument().equals(typeOfDocument)) {
				a = s;
			}
		}
		return a;

	}

	public boolean addClient(Client c) throws RepeatedClientException, RequiredFieldsException {
		boolean added = false;
		if ((searchClient(c.getID(), c.getTypeOfDocument()) != null)) {
			throw new RepeatedClientException(c.getName() + " " + c.getSurnames());
		} else if (c.getName().equals("") || c.getSurnames().equals("") || c.getTypeOfDocument().equals("")
				|| c.getID().equals("")) {
			throw new RequiredFieldsException();
		} else {
			clients.add(c);
			added = true;
		}
		return added;

	}

	public String assignTurn(Client c) {
		String currentTurn = "";
		if (currentNumber < 10) {
			currentTurn = currentLetter + "0" + currentNumber;
		} else {
			currentTurn = "" + currentLetter + currentNumber;
		}
		Turn a = new Turn(currentTurn, Turn.PENDING, c);
		turns.add(a);

		currentNumber++;
		if (currentNumber == 100) {
			currentNumber = 0;
			currentLetter++;
		}
		if (currentLetter == 91) {
			currentLetter = 65;
		}
		return currentTurn;

	}

	public Client attendTurn() {
		Client c = null;
		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i).getStatus() == Turn.PENDING) {
				c = turns.get(i).getClient();
				turns.get(i).setStatus(Turn.ATTENDING);
			}
		}
		return c;
	}

	public void finalizeTurn(String turn) {
		for (int i = 0; i < turns.size(); i++) {

		}
	}

}
