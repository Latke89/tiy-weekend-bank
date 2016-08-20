package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Brett on 8/19/16.
 */
public class Bank {

	private String bankName = "Bank of Rounding Errors";

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
			System.out.println("Please name your account");
			String acctName = inputScanner.nextLine();
			Checking myChecking = new Checking();
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			myChecking.setBalance(initialDeposit);
		} else if (accountChoice == 2) {
			System.out.println("Please name your account");
			String acctName = inputScanner.nextLine();
			Savings mySavings = new Savings();
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			mySavings.setBalance(initialDeposit);
		}else if (accountChoice == 3) {
			System.out.println("Please name your account");
			String acctName = inputScanner.nextLine();
			Retirement myRetirement = new Retirement();
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			myRetirement.setBalance(initialDeposit);
		}
	}

	public void addCustomer() {
		Scanner inputScanner = new Scanner(System.in);
		String customerName;
		System.out.println("Please enter your first name:");
		customerName = inputScanner.nextLine();
		BankCustomer myCustomer = new BankCustomer(customerName);
	}

	public void printInfo() {
		System.out.println(getBankName());

	}

	public void saveBank (Bank bank) {
		try {
			File bankFile = new File("bank.txt");
			FileWriter bankWriter = new FileWriter(bankFile);
			bankWriter.write("Bank.name: " + getBankName());
			bankWriter.write("Account holders: ");

			bankWriter.close();
		} catch (Exception exception){
			System.out.println("Something happened D'=");
			exception.printStackTrace();
		}
	}
}
