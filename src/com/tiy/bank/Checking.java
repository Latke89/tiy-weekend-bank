package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Checking extends BankAccount {


	public double interest() {
		setBalance(getBalance() * 1.00);
		return getBalance();
	}
}
