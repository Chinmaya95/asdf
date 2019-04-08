package com.cg.parallel.service;

import java.util.List;

import com.cg.parallel.bean.TransactionBean;
import com.cg.parallel.bean.WalletAccount;
import com.cg.parallel.dao.WalletDAO;
import com.cg.parallel.dao.WalletDAOImpl;
import com.cg.parallel.exception.WalletException;

public class WalletServiceImpl implements WalletService {

	WalletDAO dao=new WalletDAOImpl();
	public WalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public WalletAccount createAccount(WalletAccount acc)throws WalletException {
		// TODO Auto-generated method stub
		return dao.createAccount(acc);
	}

	@Override
	public double showBalance(String username,String password) throws WalletException {
		// TODO Auto-generated method stub
		return dao.showBalance(username,password);
	}

	@Override
	public WalletAccount deposit(String username,double amount) throws WalletException {
		// TODO Auto-generated method stub
		return dao.deposit(username, amount);
	}

	@Override
	public WalletAccount withdraw(String username,String password, double amount) throws WalletException {
		// TODO Auto-generated method stub
		return dao.withdraw(username,password, amount);
	}

	@Override
	public List<WalletAccount> fundTransfer(String fromUserName,String fromPassword,String toUserName,double amount)throws WalletException  {
		// TODO Auto-generated method stub
		return dao.fundTransfer(fromUserName,fromPassword, toUserName,amount);
	}

	@Override
	public List<TransactionBean> printTransactions(String username,String password) throws WalletException {
		// TODO Auto-generated method stub
		return dao.printTransactions(username,password);
	}

}
