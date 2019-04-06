package com.cg.wallet.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.repo.StaticDB;

public class WalletDAOImpl implements WalletDAO {

	Map<String,List<String>> lmap = StaticDB.getTransactions();
	HashMap<String, Account> map = StaticDB.getCustomers();
	ArrayList<String> list = new ArrayList<>();
	@Override
	public void addAccount(Account acc) throws WalletException {
		// TODO Auto-generated method stub
		if(map.containsKey(acc.getUserName()))
			throw new WalletException("Username exists Already");
		else
		{		
			map.put(acc.getUserName(), acc);
			Date d= new Date();
			lmap.put(acc.getUserName(), new ArrayList<>());
			lmap.get(acc.getUserName()).add("Account Created on"+ d);
		}
	}

	@Override
	public double deposit(String name,double amount) {
		// TODO Auto-generated method stub
		if(amount>0) {
			double newBalance= map.get(name).getAccBalance()+amount;
			map.get(name).setAccBalance(newBalance);
			addDepositTransaction(name, amount);
		}
		else {
			System.out.println("Amount cannot be negative");
			System.out.println("Deposit failed");
		}
		return map.get(name).getAccBalance();
	}

	@Override
	public double withdraw(String name,double amount) {
		// TODO Auto-generated method stub
		if(amount<map.get(name).getAccBalance()) {
			double newBalance= map.get(name).getAccBalance() - amount;
			map.get(name).setAccBalance(newBalance);
			addWithdrawTransaction(name, amount);
			}
		else {
			System.out.println("Withdrawl Failed!!!");
			System.out.print("Balance is:");
		}
		return map.get(name).getAccBalance();
		
	}

	@Override
	public void fundTransfer(String name, String toUserName, double amount) throws WalletException {
		// TODO Auto-generated method stub
		if(lmap.containsKey(toUserName)) {
		withdraw(name,amount);
		
		if(amount>0) {
			deposit(toUserName,amount);
			addFundTransferTransaction(name, toUserName, amount);
		}
		else {
			System.out.println("Amount cannot be negative");
			System.out.println("Deposit failed");
		}
		
		
		System.out.println("Fund transfer of" + amount + "was successful");
	}
	else {
		System.out.println("Receiver does not exists!!!!");
	}
	}
	@Override
	public List<String> printTransactions(String name) throws WalletException {
		// TODO Auto-generated method stub
		return lmap.get(name);
	}

	@Override
	public boolean validateLogin(String user, String password) {
		// TODO Auto-generated method stub
		boolean t=false;
		for(String set:map.keySet()) {
			if(user.equals(set) && password.equals(map.get(user).getPassWord())) {
				t = true;
			}
		}
		return t;
	}

	@Override
	public double showBalance(String username) {
		// TODO Auto-generated method stub
		return map.get(username).getAccBalance();
	}
	
	public void addDepositTransaction(String name,double d) {
		lmap.get(name).add("Deposited "+ d+" on " + new Date());
	}
	
	public void addWithdrawTransaction(String name,double d) {
		lmap.get(name).add("Withdrew "+ d+" on " + new Date());
	}
	
	public void addFundTransferTransaction(String name,String toName,double amount) {
		Date d= new Date();
		lmap.get(name).remove(lmap.get(name).size()-1);
		lmap.get(toName).remove(lmap.get(toName).size()-1);
		lmap.get(name).add("Transferred "+ amount+" to "+map.get(toName).getAccName()+" on " + d);
		lmap.get(toName).add("Received "+ amount+" from "+map.get(name).getAccName()+" on " + d);
	}

}
