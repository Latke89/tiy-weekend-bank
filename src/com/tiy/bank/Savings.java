package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Savings extends BankAccount {

	private String accountName = "Savings";

	public double interest() {
		setBalance(getBalance() * 1.05);
		return getBalance();
	}

	public void setAccountName(String accountName) {
		this.accountName = "Savings";
	}
}
