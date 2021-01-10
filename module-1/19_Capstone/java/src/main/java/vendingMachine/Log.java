package vendingMachine;

import java.math.BigDecimal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Log {

	public void writer(String typeOfTransaction, BigDecimal setScale, BigDecimal balance) {

		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();

		try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {

			String printToday = today.toString();
			String printNow = now.toString();
			String printTypeOfTransaction = typeOfTransaction.toString();
			String printSetScale = setScale.toString();
			String printBalance = balance.toString();

			logWriter.println(printToday + " " + printNow + " " + printTypeOfTransaction + ", " + printSetScale + ", "
					+ printBalance);

		} catch (FileNotFoundException e) {

			e.getMessage();
		}
		/*
		 * try(Scanner fileScanner = new Scanner(new FileOutputStream(new
		 * File("./log.txt")))); PrintWriter writer = new PrintWriter(tempFile)) { while
		 * (fileScanner.hasNextLine()) { String line = fileScanner.nextLine(); if
		 * (line.contains(searchWord)) { line = line.replace(searchWord, replaceWord); }
		 * } } catch (FileNotFoundException e) {
		 * System.out.println("Your file doesn't exist."); System.exit(1); }
		 */

	}
}
