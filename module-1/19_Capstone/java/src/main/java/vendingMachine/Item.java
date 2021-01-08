package vendingMachine;

import java.math.BigDecimal;

public abstract class Item {
	
	private final int STARTING_QUANTITY = 5;
	
	protected String slot;
	protected String name;
	protected BigDecimal price;
	protected String type;
	protected int quantity;

	public Item (String name, BigDecimal price, String type, String slot) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.slot = slot;
	
		this.quantity = STARTING_QUANTITY;
	}


	public String getSlot() {
		return slot;
	}


	public void setSlot(String slot) {
		this.slot = slot;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	//Add Override for String
	
	public abstract String getSound();


	public int getQuantity() {
		return quantity;
		
	}
		

}
