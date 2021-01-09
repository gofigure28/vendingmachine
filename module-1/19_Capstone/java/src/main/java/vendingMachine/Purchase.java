package vendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

	public class Purchase {
		BigDecimal balance = new BigDecimal(0.00).setScale(2);
		List<Item> purchaseList = new ArrayList<>();
		Map<String, Item> inventory = new TreeMap<>();
		Log writer = new Log();

		public Purchase(Map<String, Item> inventory) {
			this.inventory = inventory;
		}

		//Moved to InventoryLoader so the Vending Machine could display items
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

		public void feedMoney(int addMoney) {
			String typeOfTransaction = "FEED MONEY:";
			if (addMoney == 1) {
				balance = balance.add(new BigDecimal(1.00));
				writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

			} else if (addMoney == 2) {
				balance = balance.add(new BigDecimal(2.00));
				writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);
			} else if (addMoney == 3) {
				balance = balance.add(new BigDecimal(5.00));
				writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);
			} else if (addMoney == 4) {
				balance = balance.add(new BigDecimal(10.00));
				writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);
			}
			System.out.println("Your balance is " + balance);
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
			if (! InventoryLoader.containsKey(guestSelection)) { 
				System.out.println("Sorry that product does not exist, please choose a valid product");
			} 
			if (InventoryLoader.containsKey(guestSelection)) {
				if (InventoryLoader.get(guestSelection).size() == 1) {
					System.out.println("Sorry out of stock");
				}
				if (InventoryLoader.get(guestSelection).size() >= 1) {
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
						System.out.println("Your out of luck Joe, insert some cash Yo!");
					}
				}
			}
			System.out.println("Your balance is " + balance);
		}
		
		
		
	}