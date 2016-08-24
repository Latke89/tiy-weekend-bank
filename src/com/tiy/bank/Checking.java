package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Checking extends BankAccount {

	private String accountName;
	private double balance;
	private int type;



	public Checking(String accountName, double balance, int type) {
		setAccountName(accountName);
		this.setBalance(balance);
		this.setType(type);
	}

	public double interest() {
		setBalance(getBalance() * 1.00);
		return getBalance();
	}

}
