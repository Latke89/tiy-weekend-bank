package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Brett on 8/19/16.
 */
public class Bank {

	private String bankName = "Bank of Rounding Errors";
	ArrayList<String> accountHolders = new ArrayList<String>();
	HashMap<String, BankAccount> myHash = new HashMap<String, BankAccount>();

	public String getBankName() {

		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void createAccount() {
		int accountChoice;
		double initialDeposit;
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please choose an account to open");
		System.out.println("1.Checking");
		System.out.println("2.Savings");
		System.out.println("3.Retirement");
		accountChoice = Integer.valueOf(inputScanner.nextLine());
		if (accountChoice == 1){
			System.out.println("Please name your Checking account");
			String acctName = inputScanner.nextLine();
			myHash.put(acctName, new Checking());
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			myHash.get(acctName).setBalance(initialDeposit);
			System.out.println(myHash.get(acctName).getBalance());
		} else if (accountChoice == 2) {
			System.out.println("Please name your Savings account");
			String acctName = inputScanner.nextLine();
			myHash.put(acctName, new Savings());
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			myHash.get(acctName).setBalance(initialDeposit);
			System.out.println(myHash.get(acctName).getBalance());
		}else if (accountChoice == 3) {
			System.out.println("Please name your Retirement account");
			String acctName = inputScanner.nextLine();
			myHash.put(acctName, new Retirement());
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			myHash.get(acctName).setBalance(initialDeposit);
			System.out.println(myHash.get(acctName).getBalance());
		}
	}

	public void interact() {

	}

	public void addCustomer() {
		Scanner inputScanner = new Scanner(System.in);
		String customerName;
		System.out.println("Please enter your first name:");
		customerName = inputScanner.nextLine();
		accountHolders.add(customerName);
	}

	public double getTotalInDeposits() {
		double total = 0.0;
		for (HashMap.Entry<String, BankAccount> currAcct : myHash.entrySet()) {
			total += currAcct.getValue().getBalance();
		}
		return total;
	}

	public void printInfo() {
		int counter = 1;
		System.out.println(getBankName());
		for(HashMap.Entry<String, BankAccount> entry : myHash.entrySet()) {
			System.out.println(counter++ + " - " + entry.getKey() + " : " + entry.getValue().getBalance() );
		}

	}

	public void accountInteract(){
		System.out.println("Which account would you like to choose?");

	}

	public void writeBank (Bank bank) {
		FileWriter bankWriter = null;
		try {
			File bankFile = new File("bank.txt");
			bankWriter = new FileWriter(bankFile);
			bankWriter.write("Account Holders: \n");
			for (String names : accountHolders ){
				bankWriter.write(names + ",");
			}
			bankWriter.write("Accounts in Bank: \n");
			for(HashMap.Entry<String, BankAccount> entry : myHash.entrySet()) {
				bankWriter.write(entry.getKey() + " : " + entry.getValue().getBalance() + "\n");
			}

			bankWriter.close();
		} catch (Exception exception){
			System.out.println("Something happened D'=");
			exception.printStackTrace();
		} finally {
			if(bankWriter != null) {
				try {
					bankWriter.close();
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}

//	public void readBank() {
//		File bankFile = new File("bank.txt");
//		Scanner fileScanner = new Scanner(bankFile);
//		ArrayList<String> accountHolders = null;
//		while (fileScanner.hasNext()) {
//			String currentLine = fileScanner.nextLine();
//			if (currentLine.startsWith("Account"))
//			{
//				currentLine = currentLine.split(",")[1];
//			}
//
//		}
//	}
}
