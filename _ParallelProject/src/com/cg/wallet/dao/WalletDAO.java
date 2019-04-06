package com.cg.wallet.dao;

import java.util.List;
import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;

public interface WalletDAO {
	public void addAccount(Account acc) throws WalletException;
	public double deposit(String name,double amount);
	public double withdraw(String name,double amount);
	public void fundTransfer(String name,String toUserName,double amount)throws WalletException;
	public List<String> printTransactions(String name)throws WalletException ;
	public boolean validateLogin(String user,String password);
	public double showBalance(String username);
}
