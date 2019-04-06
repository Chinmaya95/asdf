package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;

public interface ApplicationService {
	public boolean validateEmpName(String empName);
	public boolean validateEmpSal(int empSal);
	public boolean validateUserName(String userName);
	public boolean validatePassword(String passWord);
	public void addAccount(Account acc) throws WalletException;
	public double deposit(String name,double amount);
	public double withdraw(String name,double amount);
	public void fundTransfer(String name,String toUserName,double amount)throws WalletException;
	public List<String> printTransactions(String name)throws WalletException ;
	public boolean validateLogin(String user,String password);
	public double showBalance(String username);
}
