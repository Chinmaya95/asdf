package com.cg.parallel.pl;

import java.util.Random;
import java.util.Scanner;

import com.cg.parallel.bean.WalletAccount;
import com.cg.parallel.exception.WalletException;
import com.cg.parallel.service.WalletService;
import com.cg.parallel.service.WalletServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WalletService service=new WalletServiceImpl();
		Scanner sc=new Scanner(System.in);
		int loopController = 0;
		String username,password;
		double amount;
		WalletAccount w=new WalletAccount();
		do
		{
			System.out.println("1-Create Account");
			System.out.println("2-Show Balance");
			System.out.println("3-Deposit");
			System.out.println("4-Withdraw");
			System.out.println("5-Fund Transfer");
			System.out.println("6-Print Transaction");
			System.out.println("7-Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1: System.out.println("Enter your User Name and password");
				try {
					Random rand = new Random();
				    String card = "";
				    for (int i = 0; i < 14; i++)
				    {
				        int n = rand.nextInt(10) + 0;
				        card += Integer.toString(n);
				    }
					System.out.println("Account with username= "+service.
							createAccount(new WalletAccount(sc.next(),card,1000.00,sc.next())).getUserName()
							+" created successfully with initial balance as RS.1000.00");
				} catch (WalletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						break;
				case 2: System.out.println("Enter Username and password");
						username=sc.next();
						password=sc.next();
						try{
							System.out.println(service.showBalance(username, password));
						}catch(Exception e){
							e.printStackTrace();
						}
						break;
				case 3: System.out.println("Enter Username and amount");
						username=sc.next();
						amount=sc.nextDouble();
						try
						{
							w=service.deposit(username, amount);
							System.out.println("Rs. "+amount+" deposited successfully");
							System.out.println("Updated account details");
							System.out.println(w);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						break;
				case 4: System.out.println("Enter Username,password and amount");
						username=sc.next();
						password=sc.next();
						amount=sc.nextDouble();
						try
						{
							w=service.withdraw(username, password, amount);
							System.out.println("Rs. "+amount+" withdrawn successfully");
							System.out.println("Updated account details");
							System.out.println(w);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						break;
				case 5: System.out.println("Enter Username,password and amount");
						username=sc.next();
						password=sc.next();
						amount=sc.nextDouble();
						System.out.println("Enter receiver's username");
						String toUserName=sc.next();
						try{
							for(WalletAccount wallet:service.fundTransfer(username, password, toUserName, amount))
								System.out.println("Updated bank account: "+wallet);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
				case 6: System.out.println("Enter Username and password");
						username=sc.next();
						password=sc.next();
						try{
							System.out.println(service.printTransactions(username, password));
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						break;
				case 7: System.exit(0);
			}
			System.out.println("Enter 1 to continue or any other number to exit");
			loopController=sc.nextInt();
		}while(loopController==1);
	}

}
