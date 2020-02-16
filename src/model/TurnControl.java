package model;

import java.util.ArrayList;

import customExceptions.IncorrectNameInputException;
import customExceptions.IncorrectSurnamesInputException;
import customExceptions.RepeatedClientException;
import customExceptions.RequiredFieldsException;

public class TurnControl {

	private ArrayList<Client> clients;
	private ArrayList<Turn> turns;
	private char currentLetter;
	private int currentNumber;

	/**
	 * Description: This it the constructor method of TurnControl class. <br>
	 */
	public TurnControl() {
		clients = new ArrayList<Client>();
		turns = new ArrayList<Turn>();
		currentLetter = 65;
		currentNumber = 0;

	}

	/**
	 * Description: This method gives us the clients's ArrayList. <br>
	 * <b>pre: </b> The list is already instantiated. <br>
	 * 
	 * @return turns's ArrayList.
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * Description: This method change the clients's ArrayList. <br>
	 * <b>pre: </b> The list is already instantiated. <br>
	 * <b>post: </b> The list has been changed.
	 * 
	 * @param clients The list of clients already changed.
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	/**
	 * Description: This method gives us the turns's ArrayList. <br>
	 * <b>pre: </b> The list is already instantiated. <br>
	 * 
	 * @return turns's ArrayList.
	 */
	public ArrayList<Turn> getTurns() {
		return turns;
	}

	/**
	 * Description: This method change the turns's ArrayList. <br>
	 * <b>pre: </b> The list is already instantiated. <br>
	 * <b>post: </b> The list has been changed.
	 * 
	 * @param turns The list of turns already changed.
	 */
	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}

	/**
	 * Description: This method search a client created in clients ArrayList. <br>
	 * <b>post: </b> The client has been finded.
	 * 
	 * @param typeOfDocument Clients's type of document that we need to search.
	 * @param ID             Clients's ID that we need to search.
	 * @return The client finded.
	 */
	public Client searchClient(String ID, String typeOfDocument) {
		Client a = null;
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getID().equals(ID) && clients.get(i).getTypeOfDocument().equals(typeOfDocument)) {
				a = clients.get(i);
			}
		}
		return a;

	}

	/**
	 * Description: This method gives us the actual letter in the controller. <br>
	 * <b>pre: </b> The letter is already created in the controller. <br>
	 * 
	 * @return current letter.
	 */
	public char getCurrentLetter() {
		return currentLetter;
	}

	/**
	 * Description: This method change the current letter. <br>
	 * <b>post: </b> The letter has been changed.
	 * 
	 * @param currentLetter is a char that sets the letter that the turn will have.
	 */
	public void setCurrentLetter(char currentLetter) {
		this.currentLetter = currentLetter;
	}

	/**
	 * Description: This method gives us the actual number in the controller. <br>
	 * <b>pre: </b> The number is already created in the controller. <br>
	 * 
	 * @return current number.
	 */
	public int getCurrentNumber() {
		return currentNumber;
	}

	/**
	 * Description: This method change the current number. <br>
	 * <b>post: </b> The number has been changed.
	 * 
	 * @param currentNumber is an int that sets the number that the turn will have.
	 */
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	/**
	 * Description: This method checks the client that method add wants to created
	 * has the name in correct format. <br>
	 * <b>post: </b> The name had been checked.
	 * 
	 * @param name Is the string we need to analize.
	 * @return A boolean, false if the name is correct and true if it is not.
	 */
	public boolean incorrectName(String name) {
		boolean incorrect = false;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			String a = "" + c;
			try {
				Integer.parseInt(a);
				incorrect = true;

			} catch (NumberFormatException excepcion) {
			}
		}
		return incorrect;

	}

	/**
	 * Description: This method checks the client that method add wants to created
	 * has the surname in correct format. <br>
	 * <b>post: </b> The surname had been checked.
	 * 
	 * @param surname Is the string we need to analize.
	 * @return A boolean, false if the surname is correct and true if it is not.
	 */
	public boolean incorrectSurname(String surname) {
		boolean incorrect = false;
		for (int i = 0; i < surname.length(); i++) {
			char c = surname.charAt(i);
			String a = "" + c;
			try {
				Integer.parseInt(a);
				incorrect = true;

			} catch (NumberFormatException excepcion) {
			}
		}
		return incorrect;

	}

	/**
	 * Description: This method adds a client to clients's ArrayList. <br>
	 * <b>post: </b> The client had been added.
	 * 
	 * @param c The client we need to add.
	 * @throws RepeatedClientException, RequiredFieldsException,
	 *                                  IncorrectNameInputException
	 *                                  IncorrectSurnamesInputException, <br>
	 *                                  1. If a client with the same ID and type of
	 *                                  document is already added. <br>
	 *                                  2. If the param client has not name,
	 *                                  surnames, typeOfDocument or ID. <br>
	 *                                  3. If the clients's name has a number. 4. If
	 *                                  the clients's surnames has a number.
	 * @return a boolean, true if the client is added and false if is not.
	 * 
	 */
	public boolean addClient(Client c) throws RepeatedClientException, RequiredFieldsException,
			IncorrectNameInputException, IncorrectSurnamesInputException {
		boolean added = false;
		if ((searchClient(c.getID(), c.getTypeOfDocument()) != null)) {
			throw new RepeatedClientException(c.getName() + " " + c.getSurnames());
		} else if (c.getName().equals("") || c.getSurnames().equals("") || c.getTypeOfDocument().equals("")
				|| c.getID().equals("")) {
			throw new RequiredFieldsException();
		} else if (incorrectName(c.getName())) {
			throw new IncorrectNameInputException();
		} else if (incorrectSurname(c.getSurnames())) {
			throw new IncorrectSurnamesInputException();
		}

		else {
			clients.add(c);
			added = true;
		}
		return added;

	}

	/**
	 * Description: This method checks the client in the param has not a turn
	 * already pending. <br>
	 * <b>post: </b> The clients's status had been checked.
	 * 
	 * @param c The client we need to check.
	 * @return a boolean, true if the client has a pending turn, false if is not.
	 * 
	 */
	public boolean pendingTurn(Client c) {
		boolean finded = false;
		boolean hasTurn = false;
		for (int i = 0; i < turns.size() && !finded; i++) {
			if (turns.get(i).getClient().equals(c) && turns.get(i).getStatus() == Turn.PENDING) {
				finded = true;
				hasTurn = true;
			}
		}
		return hasTurn;
	}

	/**
	 * Description: This method assigns a client to a turn, this way the client can
	 * be attended. <br>
	 * <b>pre: </b> The client is not assigned already to a pending turn. <br>
	 * <b>post: </b> The client had been assigned to turn. *
	 * 
	 * @param c The client we need to assign to next turn.
	 * @return a String, it is the turn that has the client n the param.
	 * 
	 */
	public String assignTurn(Client c) {
		String currentTurn = "";

		if (!pendingTurn(c)) {
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

		}
		return currentTurn;

	}

	/**
	 * Description: This method attends the next turn in the list with the status
	 * pending already. <br>
	 * <b>post: </b> The turn is being attended.
	 * 
	 * @return a String, the next turn to be attended. This is for the client knows
	 *         is the next.
	 */
	public String attendTurn() {
		String c = "";
		boolean finded = false;
		for (int i = 0; i < turns.size() && !finded; i++) {
			if (turns.get(i).getStatus() == Turn.PENDING) {
				c = turns.get(i).getIdentificator();
				finded = true;
				turns.get(i).setStatus(Turn.ATTENDING);
			}
		}
		return c;
	}

	/**
	 * Description: When the employee attends the turn or when the client was not
	 * presented for being attended. <br>
	 * <b>post: </b> Turn finalized.
	 * 
	 * @param turn It is a String with the turn the employee wants to finalize.
	 * @param was  It is a boolean, true if the client was and the employee attended
	 *             him/her and false if the client was not.
	 * 
	 */
	public void finalizeTurn(String turn, boolean was) {
		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i).getStatus() == Turn.ATTENDING && turns.get(i).getIdentificator().equals(turn)) {
				if (was) {
					turns.get(i).setStatus(Turn.ATTENDED);
				} else {
					turns.get(i).setStatus(Turn.NOT_PRESENTED);

				}
			}
		}
	}

}
