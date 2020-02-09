package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customExceptions.RepeatedClientException;
import customExceptions.RequiredFieldsException;

public class TurnControlTest {
	private TurnControl turnControlTest;

	@Test
	public void setup1() throws RepeatedClientException, RequiredFieldsException {
		turnControlTest = new TurnControl();
		Client a = new Client("CC", "1005977", "Carlos", "Restrepo", "3124567890", "Quinta con quinta");
		Client b = new Client("CC", "324567", "David", "Medina", "3234514587", "");
		Client c = new Client("CC", "123453456", "Fernando", "Carvajal", "", "");
		Client d = new Client("CC", "334441", "Camilo", "Realpe", "", "");
		assertTrue(turnControlTest.addClient(a));
		assertTrue(turnControlTest.addClient(b));
		assertTrue(turnControlTest.addClient(c));
		assertTrue(turnControlTest.addClient(d));
		Client aCopy = new Client("CC", "1005977", "Carlos", "Restrepo", "3124567890", "Quinta con quinta");
		try {
			assertFalse(turnControlTest.addClient(aCopy));
		} catch (RepeatedClientException | RequiredFieldsException e) {
			assertTrue(true);
		}

		Client f = new Client("CC", "13588732", "Camilo", "Carvajal", "", "");
		try {
			assertTrue(turnControlTest.addClient(f));
		} catch (RepeatedClientException | RequiredFieldsException e1) {
			e1.printStackTrace();
		}
		Client e = new Client("CC", "", "Daniel", "Rodr�guez", "", "");
		try {
			assertFalse(turnControlTest.addClient(e));
		} catch (RepeatedClientException | RequiredFieldsException e1) {
			assertTrue(true);
		}

	}

	@Test
	public void compareSize() throws RepeatedClientException, RequiredFieldsException {
		setup1();
		assertTrue(turnControlTest.getClients().size() == 5);

	}

	@Test
	public void searchTest() throws RepeatedClientException, RequiredFieldsException {
		setup1();
		Client g = turnControlTest.getClients().get(0);
		Client s = turnControlTest.searchClient("1005977", "CC");
		assertEquals(g.getName(), (s.getName()));
		assertEquals(g.getSurnames(), (s.getSurnames()));
		assertEquals(g.getPhone(), (s.getPhone()));

		assertNull(turnControlTest.searchClient("Passport", "Aa124576g"));
	}

	@Test
	public void assignTurnTest() throws RepeatedClientException, RequiredFieldsException {
		setup1();
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(0), "").equals("A00"));
		turnControlTest.setCurrentLetter((char) 68);
		turnControlTest.setCurrentNumber(99);
		// Client get (1) assigned to turn D99
		turnControlTest.assignTurn(turnControlTest.getClients().get(1), "");
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(2), "").equals("E00"));
		turnControlTest.setCurrentLetter((char) 90);
		turnControlTest.setCurrentNumber(99);
		// Client get (3) assigned to turn Z99
		turnControlTest.assignTurn(turnControlTest.getClients().get(3), "");
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(4), "").equals("A00"));
		// Assigned a turn to a client is still pending.
		// The assigning method return "".
		assertTrue(turnControlTest.assignTurn(turnControlTest.getClients().get(4), "").equals(""));

	}

}