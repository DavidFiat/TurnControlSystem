package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customExceptions.RepeatedClientException;
import customExceptions.RequiredFieldsException;

public class TurnControlTest {
	private TurnControl turnControlTest;
	private Client a;
	private Client b;
	private Client c;
	private Client d;
	private Client aCopy;
	private Client f;
	private Client e;

	@Test
	public void setup1() throws RepeatedClientException, RequiredFieldsException {
		turnControlTest = new TurnControl();
		a = new Client("CC", "1005977", "Carlos", "Restrepo", "3124567890", "Quinta con quinta");
		b = new Client("CC", "324567", "David", "Medina", "3234514587", "");
		c = new Client("CC", "123453456", "Fernando", "Carvajal", "", "");
		d = new Client("CC", "334441", "Camilo", "Realpe", "", "");
	}

	@Test
	public void add() throws RepeatedClientException, RequiredFieldsException {
		setup1();
		assertTrue(turnControlTest.addClient(a));
		assertTrue(turnControlTest.addClient(b));
		assertTrue(turnControlTest.addClient(c));
		assertTrue(turnControlTest.addClient(d));
		aCopy = new Client("CC", "1005977", "Carlos", "Restrepo", "3124567890", "Quinta con quinta");
		try {
			assertFalse(turnControlTest.addClient(aCopy));
		} catch (RepeatedClientException | RequiredFieldsException e) {
			assertTrue(true);
		}

		f = new Client("CC", "13588732", "Camilo", "Carvajal", "", "");
		try {
			assertTrue(turnControlTest.addClient(f));
		} catch (RepeatedClientException | RequiredFieldsException e1) {
			e1.printStackTrace();
		}
		e = new Client("CC", "", "Daniel", "Rodríguez", "", "");
		try {
			assertFalse(turnControlTest.addClient(e));
		} catch (RepeatedClientException | RequiredFieldsException e1) {
			assertTrue(true);
		}

	}

	@Test
	public void compareSize() throws RepeatedClientException, RequiredFieldsException {
		add();
		assertTrue(turnControlTest.getClients().size() == 5);

	}

	@Test
	public void searchTest() throws RepeatedClientException, RequiredFieldsException {
		add();
		Client g = turnControlTest.getClients().get(0);
		Client s = turnControlTest.searchClient("1005977", "CC");
		assertEquals(g.getName(), (s.getName()));
		assertEquals(g.getSurnames(), (s.getSurnames()));
		assertEquals(g.getPhone(), (s.getPhone()));

		assertNull(turnControlTest.searchClient("Passport", "Aa124576g"));
	}

	@Test
	public void assignTurnTest() throws RepeatedClientException, RequiredFieldsException {
		add();
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(0)).equals("A00"));
		turnControlTest.setCurrentLetter((char) 68);
		turnControlTest.setCurrentNumber(99);
		// Client get (1) assigned to turn D99
		turnControlTest.assignTurn(turnControlTest.getClients().get(1));
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(2)).equals("E00"));
		turnControlTest.setCurrentLetter((char) 90);
		turnControlTest.setCurrentNumber(99);
		// Client get (3) assigned to turn Z99
		turnControlTest.assignTurn(turnControlTest.getClients().get(3));
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(4)).equals("A00"));
		// Assigned a turn to a client is still pending.
		// The assigning method return "".
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(4)).equals(""));

	}

}
