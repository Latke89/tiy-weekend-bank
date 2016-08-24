package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Savings extends BankAccount implements Runnable{

	private String accountName = "Savings";

	public Savings(String accountName, double balance, int type) {
		this.setAccountName(getAccountName());
		this.setBalance(getBalance());
		this.setType(getType());

		Thread savingsThread = new Thread(this);
		savingsThread.start();
	}

	public double interest() {
		setBalance(getBalance() * 1.05);
		return getBalance();
	}

	public void setAccountName(String accountName) {
		this.accountName = "Savings";
	}

	public void run() {
		try {
			System.out.println("Running thread");
			while (Day10Runner.runInterestThread) {
				System.out.println("Threading in progress...");
				setBalance(getBalance() * 1.05);
				Thread.sleep(10000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
