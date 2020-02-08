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

	public Client searchClient(String ID) {
		Client a = null;
		for (Client s : clients) {
			if (s.getID().equals(ID)) {
				a = s;
			}
		}
		return a;

	}

	public boolean addClient(Client c) throws RepeatedClientException, RequiredFieldsException {
		boolean added = false;
		if (searchClient(c.getID()) != null) {
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

	public void createTurns() {
		String currentTurn = "";
		if (currentNumber < 10) {
			currentTurn = currentLetter + "0" + currentNumber;
		} else {
			currentTurn = "" + currentLetter + currentNumber;
		}
		Turn a = new Turn(currentTurn);
		System.out.println(currentTurn);
		turns.add(a);
		System.out.println(currentNumber);
		System.out.println(currentLetter);

		currentNumber++;
		if (currentNumber == 100) {
			currentNumber = 0;
			currentLetter++;
		}
		if (currentLetter == 91) {
			currentLetter = 65;
		}
		System.out.println(currentNumber);
		System.out.println(currentLetter);

	}

	public void assignTurn(Client c) {

		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i).getClient() == null) {
				turns.get(i).setClient(c);
			}
		}
	}

}
