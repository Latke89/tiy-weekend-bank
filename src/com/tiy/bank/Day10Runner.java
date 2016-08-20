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
		System.out.println("Welcome to " + myBank.getBankName() + ", how may we assist you?");
		System.out.println("What would you like to do?");
		while(true){
			int menuChoice;
			System.out.println("1.Add a customer");
			System.out.println("2.Create and account");
			System.out.println("3.Check Bank info");
			System.out.println("========");
			System.out.println("0.Exit");
			System.out.println("========");
			menuChoice = Integer.valueOf(inputScanner.nextLine());
			if (menuChoice == 1) {
				myBank.addCustomer();
			}else if (menuChoice == 2) {
				myBank.createAccount();
			}else if(menuChoice == 3) {
				myBank.printInfo();
			}else if(menuChoice == 0) {
				break;
			}
		}

//		myBank.addCustomer();
//		myBank.createAccount();
//		myBank.myChecking.printInfo();
//		myBank.printInfo();




		myBank.saveBank(myBank);








	}


}
