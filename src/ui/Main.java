package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;

public class Main {

	private TurnControl turnControl;
	private Scanner reader;

	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}

	private void showMenu() {
		int option = 0;
		while (option != 9) {
			option = 0;
			System.out.println(" ");
			System.out.println(" 1.");
			System.out.println(" 2.");
			System.out.println(" 3.");
			System.out.println(" 4.");
			System.out.println(" 5.");
			System.out.println(" 6.");
			System.out.println(" 7.");
			System.out.println(" 8.");
			System.out.println(" 9. To exit");

			try {
				option = reader.nextInt();
				reader.nextLine();
			} catch (InputMismatchException e) {
				reader.nextLine();
				System.out.println("Please type a correct character");
			}
			switch (option) {

			case (1):
			case (2):

			case (3):

			case (4):

			case (5):

			case (6):

			case (7):

			case (8):

			case (9):
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
