package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import customExceptions.RepeatedClientException;
import customExceptions.RequiredFieldsException;
import model.*;

public class Main {

	private TurnControl turnControl;
	private Scanner reader;

	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}

	public void showMenu() {
		int option = 0;
		while (option != 5) {
			option = 0;
			System.out.println(" Welcome to the turn control system.");
			System.out.println(" 1. To add a new client.");
			System.out.println(" 2. To register a turn.");
			System.out.println(" 3. To attend a turn. ");
			System.out.println(" 4. To finalize a turn. ");
			System.out.println(" 5. To exit.");

			try {
				option = reader.nextInt();
				reader.nextLine();
			} catch (InputMismatchException e) {
				reader.nextLine();
				System.out.println("Please type a correct character");
			}
			switch (option) {

			case (1):
				System.out.println("Type of document.");
				String type = reader.nextLine();
				System.out.println("Number of document.");
				String ID = reader.nextLine();
				System.out.println("Names.");
				String name = reader.nextLine();
				System.out.println("Surnames.");
				String surnames = reader.nextLine();
				System.out.println("Phone.");
				String phone = reader.nextLine();
				System.out.println("Address.");
				String address = reader.nextLine();
				Client c = new Client(type, ID, name, surnames, phone, address);
				boolean registered = false;
				try {
					registered = turnControl.addClient(c);
				} catch (RepeatedClientException | RequiredFieldsException e) {
					System.out.println(e.getMessage());
				}
				if (registered) {
					System.out.println("The client was added.");
				} else {
					System.out.println("The client was not added.");
				}
				break;
			case (2):
				System.out.println("Client´s type of document.");
				String t = reader.nextLine();
				System.out.println("Client´s number of document.");
				String number = reader.nextLine();
				Client client = turnControl.searchClient(number, t);
				String turn = turnControl.assignTurn(client);
				if (client == null) {
					System.out.println("The client does not exist.");
				} else {
					if (turn.equals("")) {
						System.out
								.println("The client has been assigned to another turn and the turn is still pending.");
						break;
					} else {
						System.out.println("Do you desire to assign a turn to this client?");
						System.out.println("Name: " + client.getName());
						System.out.println("Surname: " + client.getSurnames());
						System.out.println("Phone: " + client.getPhone());

						System.out.println("1) Yes.");
						System.out.println("2) No.");
						int opt = 0;
						try {
							opt = reader.nextInt();
							reader.nextLine();
						} catch (InputMismatchException i) {
							reader.nextLine();
							System.out.println("Please type a correct character");
						}
						if (opt == 1) {
							System.out.println("The turn assignated to" + " " + client.getName() + " "
									+ client.getSurnames() + " is: " + turn);
						} else if (opt == 2) {
							break;
						}
					}
				}
				break;
			case (3):
				String a = turnControl.attendTurn();
				System.out.println(a);
				break;
			case (4):
				System.out.println("Type the turn you will finalize.");
				String turn1 = reader.next();
				System.out.println("Choose an option.");
				System.out.println("1) If the client was attended.");
				System.out.println("2) If the client did not show up.");
				int clientStatu = 0;
				try {
					clientStatu = reader.nextInt();
					reader.nextLine();
				} catch (InputMismatchException i) {
					reader.nextLine();
					System.out.println("Please type a correct character");
				}
				boolean clientStatus = false;
				if (clientStatu == 1) {
					clientStatus = true;
				}
				turnControl.finalizeTurn(turn1, clientStatus);
				break;
			case (5):
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Please choose a correct option");

			}
		}
	}

	public Main() {
		reader = new Scanner(System.in);
		turnControl = new TurnControl();
	}
}
