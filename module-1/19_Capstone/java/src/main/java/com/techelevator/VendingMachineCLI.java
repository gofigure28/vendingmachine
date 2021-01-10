package com.techelevator;

import java.util.Map;

import com.techelevator.view.Menu;
import vendingMachine.Purchase;
import vendingMachine.InventoryLoader;
import vendingMachine.Item;
import vendingMachine.Money;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private Menu menu;
	//Removed final from inventory
	private Map<String, Item> inventory;
	private InventoryLoader mainInventory = new InventoryLoader();
	private Money money = new Money();

	public VendingMachineCLI(Menu menu) {
		this.inventory = mainInventory.getInventory();
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				mainInventory.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				Purchase purchaseMenu = new Purchase(inventory, money);
				purchaseMenu.runPurchaseMenu();
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thanks for using this vending machine. Goodbye.");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
