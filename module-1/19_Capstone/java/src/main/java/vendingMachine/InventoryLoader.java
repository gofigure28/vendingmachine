package vendingMachine;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryLoader {

	
/*
 * add inventory - Map
 * 
 * try w/ while loop (stock > 0)
 * 
 * loop through list/inventory create inventory items
 * 
 */
	protected Map<String, Item> inventory;
	
	public InventoryLoader() {
		initializeInventory(); 
	}
	
	public void initializeInventory() {
		
		//read csv into a file
		File csvFile = new File("vendingmachine.csv");
		
		//read csv into a scanner
		try(Scanner csvReader = new Scanner(csvFile)) {
			inventory = new HashMap<String, Item>();
			
			//Convert file into inventory map
			while(csvReader.hasNextLine()) {
				String line = csvReader.nextLine();
				//convert individual line into an item
				Item item = convertToItem(line);
				
				//Checking to make sure the item type exist as one of the 4 prebuilt classes
				if(item == null) {
					System.out.println("Item does not exist.");
				} else {
					//If item type exist then put into map
					inventory.put(item.getName(), item);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			
		}

	}
	
	public Item convertToItem(String line) {
		//Splitting the line into separate strings and adding them to an array
		String[] itemInfo = line.split("\\|");
		
		String name = itemInfo[1];
		BigDecimal price = BigDecimal.valueOf(Double.valueOf(itemInfo[2]));
		String type = itemInfo[3];
		String slot = itemInfo[0];
		
		Item item;
		
		if(type.equals("Chip")) {
			item = new Chip(name, price, type, slot);
		} else if(type.equals("Drink")) {
			 item = new Beverages(name, price, type, slot);
		} else if(type.equals("Candy")) {
			 item = new Candy(name, price, type, slot);
		} else if(type.equals("Gum")) {
			 item = new Gum(name, price, type, slot);
		} else {
			 item = null;
		}
		
		
		return item;
	}

	public Map<String, Item> getInventory() {
		return this.inventory; 
	}
	
	
	
	public static boolean containsKey(String guestSelection) {
		
		//return inventory.containsKey(guestSelection);
		return false;
	}

	public static List<Item> get(String guestSelection) {
		// TODO Auto-generated method stub
		return null;
	}

}
