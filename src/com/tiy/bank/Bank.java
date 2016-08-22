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
	ArrayList<Customer> accountHolders = new ArrayList<Customer>();
	HashMap<String, BankAccount> myHash = new HashMap<String, BankAccount>();
	Scanner inputScanner = new Scanner(System.in);

	public String getBankName() {

		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void createAccount() {
		int accountChoice;
		double initialDeposit;
		int index = 1;
		System.out.println("Please choose customer:");
//		for (Customer currentCustomer : accountHolders) {
//			System.out.println(index + ": " + currentCustomer);
//			int customerChoice = Integer.valueOf(inputScanner.nextLine());


			while (true) {
				System.out.println("Please choose an account to open");
				System.out.println("1.Checking");
				System.out.println("2.Savings");
				System.out.println("3.Retirement");
				System.out.println("========");
				System.out.println("0.Exit");
				System.out.println("========");
				accountChoice = Integer.valueOf(inputScanner.nextLine());
				if (accountChoice == 1) {
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
				} else if (accountChoice == 3) {
					System.out.println("Please name your Retirement account");
					String acctName = inputScanner.nextLine();
					myHash.put(acctName, new Retirement());
					System.out.println("How much money would you like to put into your account?");
					initialDeposit = Double.valueOf(inputScanner.nextLine());
					myHash.get(acctName).setBalance(initialDeposit);
					System.out.println(myHash.get(acctName).getBalance());

				}
			}
	}


	public void addCustomer() {
		System.out.println("Please enter your first name:");
		String userName = inputScanner.nextLine();
		Customer myCustomer = new Customer(userName);
		accountHolders.add(myCustomer);
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
		for (Customer customer : accountHolders){
			System.out.println(customer.getUserName());
		}
		for(HashMap.Entry<String, BankAccount> entry : myHash.entrySet()) {
			System.out.println(counter++ + " - " + entry.getKey() + " : " + entry.getValue().getBalance() );
		}

	}

	public void accountInteract(){

		while (true) {
			System.out.println("Which account would you like to choose?");
			System.out.println("Type \"exit\" to exit\n");
			for (String accountName : myHash.keySet()) {
				System.out.println(accountName);
			}

			String userChoice = inputScanner.nextLine();
			System.out.println("You chose " + userChoice);
			if (userChoice == null || userChoice.equals("exit")) {
				break;
			}

			BankAccount userChosenAccount = myHash.get(userChoice);
			if(userChosenAccount == null) {
				System.out.println("Unknown Account beep boop beep");
			} else {
				while(true) {
					System.out.println("What would you like to do?");
					System.out.println("1.Deposit");
					System.out.println("2.Withdraw");
					System.out.println("3.Print Info");
					System.out.println("4.Transfer between accounts");
					System.out.println("========");
					System.out.println("0.Exit");
					System.out.println("========");
					int bankingChoice = Integer.valueOf(inputScanner.nextLine());
					if(bankingChoice == 1) {
						System.out.println("How much would you like to deposit?\n");
						double deposit = Double.valueOf(inputScanner.nextLine());
						userChosenAccount.deposit(deposit);
					} else if(bankingChoice == 2) {
						System.out.println("How much would you like to withdraw?\n");
						double withdraw = Double.valueOf(inputScanner.nextLine());
						userChosenAccount.withdraw(withdraw);
					}else if(bankingChoice == 3) {
						userChosenAccount.printInfo();
					}else if(bankingChoice == 4) {
						System.out.println("How much would you like to transfer?\n");
						double toTransfer = Double.valueOf(inputScanner.nextLine());
						System.out.println("Which account would you like to transfer to?\n");
						for (String accountName : myHash.keySet()) {
							System.out.println(accountName);
						}
						String transferChoice = inputScanner.nextLine();
						System.out.println("We will transfer to " + transferChoice);
						BankAccount transferAccount = myHash.get(transferChoice);
						if(transferAccount == null) {
							System.out.println("Beep Boop Beep Something happened\n");
							break;
						} else {
							userChosenAccount.withdraw(toTransfer);
							transferAccount.deposit(toTransfer);
							System.out.println("Transfer complete \n");
						}


					}else if(bankingChoice == 0) {
						break;
					}
				}
			}
		}
	}

	public void writeBank (Bank bank) {
		FileWriter bankWriter = null;
		FileWriter accountWriter = null;
		try {
			File bankFile = new File("bank.txt");
			File accountFile = new File("customer-name-accounts.txt");
			accountWriter = new FileWriter(accountFile);
			bankWriter = new FileWriter(bankFile);
			bankWriter.write("Account Holders: \n");
			for (Customer myCustomers : accountHolders ){
				bankWriter.write(myCustomers.getUserName() + ",");
			}
			bankWriter.write("Accounts in Bank: \n");
			for(HashMap.Entry<String, BankAccount> entry : myHash.entrySet()) {
				accountWriter.write(entry.getKey() + " : " + entry.getValue().getBalance() + "\n");
			}
			accountWriter.close();
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

	public void readBank() {
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
	}
}
