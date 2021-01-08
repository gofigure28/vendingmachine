package vendingMachine;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class BeveragesTest {
	Beverages sut;

	@Before
	public void setUp() throws Exception {
		sut = new Beverages("Coke", new BigDecimal("1.50"), "Drink", "C1");
	}

	@Test
	public void testConstructor() {

		assertEquals("Coke", sut.getName());
		assertEquals("1.50", sut.getPrice().toString());
		assertEquals("Drink", sut.getType());
		assertEquals("C1", sut.getSlot());
		assertEquals("5", sut.getQuantity());
	}
}