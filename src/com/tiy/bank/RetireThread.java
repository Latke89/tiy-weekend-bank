package com.tiy.bank;

/**
 * Created by Brett on 8/22/16.
 */
public class RetireThread implements Runnable {
	public void run(double retire) {
		System.out.println("Running " + Thread.currentThread().getId());
		try {
			Thread.sleep(120000);
		} catch (Exception exception){
			exception.printStackTrace();
		}
		System.out.println("Done running " + Thread.currentThread());
	}
}
