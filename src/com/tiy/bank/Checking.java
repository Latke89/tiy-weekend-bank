package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Checking extends BankAccount {

	private String accountName = "Checking";


	public double interest() {
		setBalance(getBalance() * 1.00);
		return getBalance();
	}

	public void setAccountName(String accountName) {
		this.accountName = "Checking";
	}
}
