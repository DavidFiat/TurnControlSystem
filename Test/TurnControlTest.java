import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customExceptions.RepeatedClientException;
import customExceptions.RequiredFieldsException;
import model.*;

class TurnControlTest {

	private TurnControl turnControlTest;

	private void setup1() throws RepeatedClientException, RequiredFieldsException {
		turnControlTest = new TurnControl();
		Client a = new Client("CC", "1005977", "Carlos", "Restrepo", "3124567890", "Quinta con quinta");
		Client b = new Client("CC", "324567", "David", "Medina", "3234514587", "");
		Client c = new Client("CC", "123453456", "Fernando", "Carvajal", "", "");

		assertTrue(turnControlTest.getClients().size() == 3);
		assertTrue(turnControlTest.addClient(a));
		assertTrue(turnControlTest.addClient(b));
		assertTrue(turnControlTest.addClient(c));

	}

	private void setup2() throws RepeatedClientException, RequiredFieldsException {
		Client aCopy = new Client("CC", "1005977", "Carlos", "Restrepo", "3124567890", "Quinta con quinta");
		assertFalse(turnControlTest.addClient(aCopy));

	}

//		@Test
//		public void testWhattype() {
//			setup1();
//			assertTrue(trg.whatType().equals(Triangle.NO_TRIANGLE));
//			setup2();
//			assertTrue(trg.whatType().equals(Triangle.EQUILATERAL));
//			setup3();
//			assertTrue(trg.whatType().equals(Triangle.SCALENE));
//			setup4();
//			assertTrue(trg.whatType().equals(Triangle.ISOSCELES));

	// }

}
