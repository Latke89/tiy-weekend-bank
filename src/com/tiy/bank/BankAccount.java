package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public abstract class BankAccount{

	private String accountName;
	private double balance = 0.00;
	private int type;

	public String getAccountName() {
		return accountName;
	}

//	public BankAccount(String accountName, double balance) {
//		this.accountName = accountName;
//		this.balance = balance;
//	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public double interest() {

	return getBalance();
	}


}
