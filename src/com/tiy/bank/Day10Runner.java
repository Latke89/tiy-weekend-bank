package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Brett on 8/19/16.
 */
public class Day10Runner {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		Bank myBank = new Bank();
		BankCustomer myCustomer = new BankCustomer("Brett");
		System.out.println("Welcome to " + myBank.getBankName() + ", how may we assist you?");


		myBank.createAccount();

		myBank.addCustomer();




		myBank.saveBank(myBank);








	}


}
