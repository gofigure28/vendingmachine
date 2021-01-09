package vendingMachine;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class InventoryLoaderTest {
	InventoryLoader il;

	@Before
	public void setUp() throws Exception {
		il = new InventoryLoader();
	}

	@Test
	public void testConstructor() {
		String actual = il.getInventory().get("Stackers").type;
		
		assertEquals( "Chip", actual);
		
//		System.out.println(il.getInventory().entrySet());   //view values
	}
	@Test
	public void testConvertToItem() {
		String line = "A1|Potato Crisps|3.05|Chip";
		
		String actual = il.convertToItem(line).getName();
		
		assertEquals("Potato Crisps", actual);
	}
	@Test
	public void testGetInventory() {
		assertNotNull(il.getInventory());
	}
}