package vendingMachine;

import java.math.BigDecimal;

public class Beverages extends Item {

	public Beverages(String name, BigDecimal price, String type, String slot) {
		super(name, price, type, slot);
	}

	public String getSound() {
		return "Glug Glug, Yum!";
	}

	public int getQuantity() {
		return super.getQuantity();
	}

	
}
