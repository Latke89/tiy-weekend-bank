package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Brett on 8/19/16.
 */
public class Bank {

	private String bankName = "Bank of Rounding Errors";
	BankAccount myChecking = new Checking();
	BankAccount mySavings = new Savings();
	BankAccount myRetirement = new Retirement();
	BankCustomer myCustomer = new BankCustomer("Brett");

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
			myChecking.setAccountName(acctName);
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			myChecking.setBalance(initialDeposit);
			System.out.println(myChecking.getBalance());
		} else if (accountChoice == 2) {
			System.out.println("Please name your account");
			String acctName = inputScanner.nextLine();
			Savings mySavings = new Savings();
			mySavings.setAccountName(acctName);
			System.out.println("How much money would you like to put into your account?");
			initialDeposit = Double.valueOf(inputScanner.nextLine());
			mySavings.setBalance(initialDeposit);
		}else if (accountChoice == 3) {
			System.out.println("Please name your account");
			String acctName = inputScanner.nextLine();
			Retirement myRetirement = new Retirement();
			myRetirement.setAccountName(acctName);
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
		System.out.println(myCustomer.getName());

	}

	public void accountInteract(){

	}

	public void saveBank (Bank bank) {
		FileWriter bankWriter = null;
		try {
			File bankFile = new File("bank.txt");
			bankWriter = new FileWriter(bankFile);
			bankWriter.write("Bank.name: " + getBankName() + "\n");
			bankWriter.write("Account holders " + myCustomer.getName() + "\n");
			bankWriter.write("Accounts in Bank: " + myChecking.getAccountName() + " " + myChecking.getBalance() + "\n");
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
}
