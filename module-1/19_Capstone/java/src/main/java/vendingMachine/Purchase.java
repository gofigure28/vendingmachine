package vendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.view.Menu;

public class Purchase {
//		BigDecimal balance = new BigDecimal(0.00).setScale(2);
	BigDecimal balance;
	List<Item> purchaseList = new ArrayList<>();
	Map<String, Item> inventory;
	Log writer = new Log();
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PURCHASE = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_PURCHASE, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private Menu menu = new Menu(System.in, System.out);

	public Purchase(Map<String, Item> inventory, Money money) {
		this.inventory = inventory;
	}

	// Moved to InventoryLoader so the Vending Machine could display items
//		public void displayInventory() {
//			for (Map.Entry<String, Item> entry : inventory.entrySet()) {
//				String key = entry.getKey();
//				Item value = entry.getValue();
//				if (value.getQuantity() == 0) {
//					System.out.println(key + " Out of stock");
//				} else {
//
//				}
//				System.out.println(key + " " + (value.getQuantity() - 1));
//			}
//		}

	public Map<String, Item> runPurchaseMenu() {
		boolean running = true;
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			Scanner sc;
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				sc = new Scanner(System.in);
				System.out.println("How much money would you like to input?" + "\n");
				System.out.println("\n" + "1) $1.00 \n" + "2) $2.00 \n" + "3) $5.00 \n" + "4) $10.00 \n" + ">>>>");
				try {
					int moneyChoice = sc.nextInt();

					if (moneyChoice > 4 || moneyChoice < 1) {
						System.out.println("Not a choice");
					} else {
						feedMoney(moneyChoice);
					}
				} catch (InputMismatchException e) {
					System.out.println("Enter a number between 1 and 4 with no decimal please");
				}
			} else if (choice.equals(PURCHASE_MENU_OPTION_PURCHASE)) {
				sc = new Scanner(System.in);
			}
		}
		return null;
	}

	public void feedMoney(int addMoney) {
		String typeOfTransaction = "FEED MONEY:";
		if (addMoney == 1) {
			Money.addToBalance(1);
			balance = BigDecimal.valueOf(Long.valueOf(Money.getBalance()));
			writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

		} else if (addMoney == 2) {
			Money.addToBalance(2);
			balance = BigDecimal.valueOf(Long.valueOf(Money.getBalance()));
			writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);

		} else if (addMoney == 3) {
			Money.addToBalance(5);
			balance = BigDecimal.valueOf(Long.valueOf(Money.getBalance()));
			writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);

		} else if (addMoney == 4) {
			Money.addToBalance(10);
			balance = BigDecimal.valueOf(Long.valueOf(Money.getBalance()));
			writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);

		}
//			System.out.println("Your balance is " + balance);
	}

	public void completeTransaction() {
		Money thisChange = new Money();
		thisChange.giveChange(balance);
		writer.writer("GIVE CHANGE:", balance, new BigDecimal(0.00).setScale(2));
		while (purchaseList.size() > 0) {
			Item purchases = purchaseList.remove(0);
			System.out.println(purchases.getSound());
		}
	}

	public void purchase(String guestSelection) {

		String customerSelection = containsSlotId(guestSelection);

		if (customerSelection.equals("Non-Existant")) {
			System.out.println("Sorry that product does not exist, please choose a valid product");
		}

		if (!customerSelection.equals("Non-Existant") && inventory.get(customerSelection).getQuantity() == 0) {
			System.out.println("Sorry out of stock");
		} else {
			if (balance.compareTo(InventoryLoader.get(guestSelection).get(0).price) >= 0) {
				balance = balance.subtract(InventoryLoader.get(guestSelection).get(0).price);
				Item p = InventoryLoader.get(guestSelection).remove(0);
				purchaseList.add(p);
				Item cost = InventoryLoader.get(guestSelection).get(1);
				BigDecimal costOne = cost.price;
				Item nameOne = InventoryLoader.get(guestSelection).get(0);
				String productOne = nameOne.name + " " + guestSelection;
				writer.writer(productOne, costOne, balance);
			} else {
				System.out.println("You're out of luck Joe, insert some cash Yo!");
			}
		}

		System.out.println("Your balance is " + balance);
	}

	public String containsSlotId(String guestSelection) {
		for (Map.Entry<String, Item> entry : inventory.entrySet()) {
			if (entry.getValue().getSlot().equals(guestSelection)) {
				return entry.getKey();
			}
		}

		return "Non-Existant";
	}
	
	
	/*Old code
	 * if (balance.compareTo(InventoryLoader.get(guestSelection).get(0).price) >= 0) {
					balance = balance.subtract(InventoryLoader.get(guestSelection).get(0).price);
					Item p = InventoryLoader.get(guestSelection).remove(0);
					purchaseList.add(p);
					Item cost = InventoryLoader.get(guestSelection).get(1);
					BigDecimal costOne = cost.price;
					Item nameOne = InventoryLoader.get(guestSelection).get(0);
					String productOne = nameOne.name + " " + guestSelection;
					writer.writer(productOne, costOne, balance);
				}**/
	 
}

