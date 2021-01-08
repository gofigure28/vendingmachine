package vendingMachine;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String name, BigDecimal price, String type, String slot) {
		super(name, price, type, slot);
	}

	public String getSound() {
		return "Munch Munch, Yum!";
	}
	
	public int getQuantity() {
		return super.getQuantity();
	}

}
