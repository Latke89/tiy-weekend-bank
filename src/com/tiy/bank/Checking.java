package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Checking extends BankAccount {

	private String accountName = "Checking";

	public Checking(String accountName, double balance, int type) {
		this.setAccountName(getAccountName());
		this.setBalance(getBalance());
		this.setType(getType());
	}

	public double interest() {
		setBalance(getBalance() * 1.00);
		return getBalance();
	}

	public void setAccountName(String accountName) {
		this.accountName = "Checking";
	}
}
