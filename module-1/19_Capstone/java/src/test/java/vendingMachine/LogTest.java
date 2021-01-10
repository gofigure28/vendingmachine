package vendingMachine;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class LogTest {
	Log testWriter = new Log();
	Scanner testScanner = new Scanner("./log.txt");
	
	@Before
	//Ask what Initialization error means
	//@Before test isn't supposed to be run or tested individually. It automatically runs before each test labeled with a @Test annotation.
	public void setUp() throws Exception {
		testWriter.writer("Hello", new BigDecimal(2.410), new BigDecimal(3.428));
	}
	
	@Test
	
	public void test() {
		assertsEquals(true, testScanner.hasNextLine());
		assertsEquals(false, testScanner.hasNextLine());
	}

	private void assertsEquals(boolean b, boolean hasNextLine) {
		// TODO Auto-generated method stub
		
	}
}
