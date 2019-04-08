package com.cg.parallel.service;

import java.util.List;

import com.cg.parallel.bean.TransactionBean;
import com.cg.parallel.bean.WalletAccount;
import com.cg.parallel.exception.WalletException;

public interface WalletService {

	public WalletAccount createAccount(WalletAccount acc)throws WalletException;
	public double showBalance(String username,String password)throws WalletException;
	public WalletAccount deposit(String username,double amount)throws WalletException;
	public WalletAccount withdraw(String username,String password,double amount)throws WalletException;
	public List<WalletAccount> fundTransfer(String fromUserName,String fromPassword,
								String toUserName,double amount)throws WalletException;
	public List<TransactionBean> printTransactions(String username,String password)throws WalletException;
}
