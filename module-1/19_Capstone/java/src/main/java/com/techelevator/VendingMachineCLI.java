package com.techelevator;

import java.util.Map;

import com.techelevator.view.Menu;
import vendingMachine.Purchase;
import vendingMachine.InventoryLoader;
import vendingMachine.Item;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;
	private final Map<String, Item> inventory;
	private InventoryLoader mainInventory = new InventoryLoader();
	

	public VendingMachineCLI(Menu menu) {
		this.inventory = null;
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				mainInventory.displayInventory();
				
			}
			//I commented this out because we need to provide different variables for purchase option
			
			//} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				
				//Example of what Matavia did with her Purchase option
				
				//System.out.println("Available balance: " + balance.getFormattedBalanceInDollars());
				//String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			}
		}
	

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
