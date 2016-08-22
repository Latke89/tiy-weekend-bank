package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Savings extends BankAccount {

	public void interest() {
		setBalance(getBalance() * 1.05);
	}
}
