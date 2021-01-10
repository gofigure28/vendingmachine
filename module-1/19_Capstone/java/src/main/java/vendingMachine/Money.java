package vendingMachine;

import java.math.BigDecimal;

public class Money {

	private static int remainingBalance = 0;
	private int numberOfQuarters = 0;
	private int numberOfDimes = 0;
	private int numberOfNickels = 0;
	int quarter = 25;
	int dime = 10;
	int nickel = 5;

	public String giveChange(BigDecimal balance) {

		while (remainingBalance > 0) {
			if (remainingBalance > quarter) {
				numberOfQuarters++;
				remainingBalance -= quarter;
			} else if (remainingBalance > dime) {
				numberOfDimes++;
				remainingBalance -= dime;
			} else if (remainingBalance > nickel) {
				numberOfNickels++;
				remainingBalance -= nickel;
			}

		}

		String amountOfChange = "Your change is: " + numberOfQuarters + " Quarter, " + numberOfDimes + " Dime, "
				+ numberOfNickels + " Nickel";
		return amountOfChange;
	}

	public static String getFormattedBalance() {
		int dollars = remainingBalance / 100;
		int cents = remainingBalance - dollars * 100;
		String centString = cents >= 10 ? "." + cents : ".0" + cents;
		return "$" + dollars + centString;
	}
	//addToBalance method tracking current balance
	public static int addToBalance(int moneyToAdd) {
		return remainingBalance += (moneyToAdd * 100);
	}
	
	public static int getBalance() {
		return remainingBalance;
	}
}
