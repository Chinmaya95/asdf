package com.cg.wallet.ui;

import java.util.*;
import java.util.Scanner;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.ApplicationServiceImpl;

public class Application {

	public static void main(String[] args) throws WalletException {
		ApplicationServiceImpl service = new ApplicationServiceImpl();
		// TODO Auto-generated method stub
		Scanner m = new Scanner(System.in);
		Account acc;
		String b,c="",d;
	A:	while(true) {
		System.out.println("1.Login");
		System.out.println("2.Register");
		System.out.println("3.Exit");
		int i = m.nextInt();
		if(i==2) {
		System.out.println();
		while(true) {
		System.out.println("*****************Enter details for account************************");
		System.out.println("Enter account holder's name:");
		b = m.next();
		if(service.validateEmpName(b)) {
			System.out.println("Enter Username:");
			c = m.next();
			if(service.validateUserName(c)) {
				System.out.println("Enter password:");
				d = m.next();
				if(service.validatePassword(d)) {
					acc= new Account(b,c,d);
					service.addAccount(acc);
					System.out.println("Account successfully created with minimum balance of : " + acc.getAccBalance());
					break;
				}
				else {
					System.out.println("Wrong pattern");
					break;}
			}
			else {
				System.out.println("Wrong pattern");
				break;}
		}
		else {
			System.out.println("Wrong pattern");
			break;}
		}
		}
		if(i==1) {
			System.out.println("Enter username");
			String u = m.next();
			System.out.println("Enter password");
			String p = m.next();
			if(service.validateLogin(u,p)) {
				System.out.println("Login successful!!!!");
				System.out.println();
				while(true) {
					
					System.out.println("1-Show Balance");
					System.out.println("2-Deposit");
					System.out.println("3-Withdraw");
					System.out.println("4-Fund Transfer");
					System.out.println("5-Print Transaction");
					System.out.println("6-Back");
					System.out.println("Enter your choice");
					int choice=m.nextInt();
					
					switch(choice) {
					case 1:
						double balance = service.showBalance(u);
						System.out.println("Your balance is:" + balance);
						break;
					case 2:
						double depAmt;
						while(true) {
						System.out.println("Enter amount that u want to deposit:");
						try {
						depAmt = m.nextDouble();
						break;
						}
						catch(Exception e) {
							System.out.println("Please enter digit only");
						}
						}
						System.out.println(depAmt + "Deposited Successfully:");
						System.out.println("Updated balance is: " + service.deposit(u, depAmt));
		
						break;
					case 3:
						double withAmt;
						while(true) {
						System.out.println("Enter amount that u want to withdraw:");
						try {
						withAmt = m.nextDouble();
						break;
						}
						catch(Exception e) {
							System.out.println("Please enter digit only");
						}
						}
						System.out.println(withAmt + "Withdrawn Successfully");
						System.out.println("Updated balance is : " + service.withdraw(u, withAmt));
						break;
					case 4:
						String othuser;
						double amount;
						while(true) {
						System.out.println("Enter username of the account to which u want to transfer money and the amount");
						try {
						othuser = m.next();
						amount = m.nextDouble();
						break;
						}
						catch(Exception e) {
							System.out.println("Please enter values in correct format");
						}
						}
						System.out.println("Funds tranfered successfully :");
						service.fundTransfer(u, othuser, amount);
						break;
					case 5:
						System.out.println();
						List<String> transactionlist = service.printTransactions(u);
						if(!transactionlist.isEmpty()) {
						for(String trans:transactionlist) {
							System.out.println(trans);
						}
						}
						else {
							System.out.println("No transaction was found!!!!");
						}
						break;
						
					case 6:
						continue A;
					default:
						System.out.println("Invalid input!!!Please try again..");
					}

				}
			}
			else {
				System.out.println("Login failed");
			}
		}
		if(i==3)
			System.exit(0);
		}
	}
}
