package com.tiy.bank;

import java.util.HashMap;

/**
 * Created by Brett on 8/22/16.
 */
public class Customer {
	private String userName;
	private HashMap<String, BankAccount> customerAccounts = new HashMap<String, BankAccount>();

	public Customer(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
