package vendingMachine;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {
	Chip sut;

	@Before
	public void setUp() throws Exception {
		sut = new Chip("Lays", new BigDecimal("1.50"), "Snack", "B2");
	}

	@Test
	public void testConstructor() {

		assertEquals("Lays", sut.getName());
		assertEquals("1.50", sut.getPrice().toString());
		assertEquals("Drink", sut.getType());
		assertEquals("C1", sut.getSlot());
	}
}