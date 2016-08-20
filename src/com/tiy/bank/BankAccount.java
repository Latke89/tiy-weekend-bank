package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public abstract class BankAccount {

	private String accountName;
	private double balance = 0.00;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double deposit(double depositAmount) {

		balance += depositAmount;
		return balance;
	}

	public double withdraw(double withdrawAmount) {
		balance -= withdrawAmount;
		return balance;
	}


	public void printInfo() {
		System.out.println(getAccountName());
		System.out.println(getBalance());

	}

	public void interest() {


	}


}
