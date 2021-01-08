package vendingMachine;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {
Candy sut;

	@Before
	public void setUp() throws Exception { 
		sut = new Candy("HersheyBar", new BigDecimal("1.50"), "Snack", "A1");	
	}

	@Test
	public void testConstructor() {
		
			assertEquals("HersheyBar", sut.getName());			
			assertEquals("1.50", sut.getPrice().toString());
			assertEquals("Drink", sut.getType());
			assertEquals("C1", sut.getSlot());
	}
}