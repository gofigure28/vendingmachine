package vendingMachine;

import java.math.BigDecimal;

public class Chip extends Item {

	
	public Chip (String name, BigDecimal price, String type, String slot) {
			super(name, price, type, slot);
			
	}

	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
	
	public int getQuantity() {
		return super.getQuantity();
	}

}
