package com.tiy.bank;

import java.util.HashMap;

/**
 * Created by Brett on 8/22/16.
 */
public class SavingsThread implements Runnable {
	public void run(Bank myBank) {
		System.out.println("Running " + Thread.currentThread().getId());
		try {
			for (Customer myCustomer : myBank.accountHolders) {
				for (HashMap.Entry<String, BankAccount> currAcct : myCustomer.customerAccounts.entrySet()) {
					if (currAcct.getValue() == new Savings()) {
						myCustomer.customerAccounts.get(currAcct).interest();
						Thread.sleep(10000);

					}
				}
			}

		} catch (Exception exception){
			exception.printStackTrace();
		}
		System.out.println("Done running " + Thread.currentThread());
	}
}
