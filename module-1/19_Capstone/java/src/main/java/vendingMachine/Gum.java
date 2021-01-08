package vendingMachine;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String name, BigDecimal price, String type, String slot) {
		super(name, price, type, slot);

	}

	public String getSound() {
		return "Chew Chew, Yum!";
	}
}


