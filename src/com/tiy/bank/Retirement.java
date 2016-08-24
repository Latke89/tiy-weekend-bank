package com.tiy.bank;

/**
 * Created by Brett on 8/19/16.
 */
public class Retirement extends BankAccount implements Runnable{



	private String accountName = "Retirement";

	public Retirement(String accountName, double balance, int type) {
		this.setAccountName(getAccountName());
		this.setBalance(getBalance());
		this.setType(getType());

		Thread retirementThread = new Thread(this);
		retirementThread.start();
	}

	public double interest() {
		setBalance(getBalance() * 1.10);
		return getBalance();
	}
	public void setAccountName(String accountName) {
		this.accountName = "Retirement";
	}

	public void run() {
		try {
			System.out.println("Running thread for Retirement");
			while (Day10Runner.runInterestThread = true) {
				System.out.println("Threading in progress..");
				setBalance(getBalance() * 1.10);
				Thread.sleep(120000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
