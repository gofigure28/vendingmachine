package vendingMachine;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;


public class GumTest {
	Gum sut;

	@Before
	public void setUp() throws Exception {
		sut = new Gum("JuicyFruit", new BigDecimal("1.50"), "Snack", "C2");
	}

	@Test
	public void testConstructor() {

		assertEquals("JuicyFruit", sut.getName());
		assertEquals("1.50", sut.getPrice().toString());
		assertEquals("Drink", sut.getType());
		assertEquals("C1", sut.getSlot());
	}
}