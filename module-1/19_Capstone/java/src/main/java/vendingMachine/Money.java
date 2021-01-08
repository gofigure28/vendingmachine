package vendingMachine;

import java.math.BigDecimal;

public class Money {

	private int remainingBalance;
	private int numberOfQuarters = 0;
	private int numberOfDimes = 0;
	private int numberOfNickels = 0;
	int quarter = 25;
	int dime = 10;
	int nickel = 5;

	public String giveChange() {

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

	public String getFormattedBalance() {
		int dollars = remainingBalance / 100;
		int cents = remainingBalance - dollars * 100;
		String centString = cents >= 10 ? "." + cents : ".0" + cents;
		return "$" + dollars + centString;
	}
	//addToBalance method tracking current balance
}
