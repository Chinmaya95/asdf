package com.cg.wallet.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.wallet.bean.Account;
import com.cg.wallet.dao.WalletDAOImpl;
import com.cg.wallet.exception.WalletException;

public class ApplicationServiceImpl implements ApplicationService {
	
	WalletDAOImpl dao = new WalletDAOImpl();

	@Override
	public boolean validateEmpName(String empName) {
		// TODO Auto-generated method stub
		String pattern = "[A-Z]{1}[a-z]{2,}";
		
		return Pattern.matches(pattern,empName);
	}

	@Override
	public boolean validateEmpSal(int empSal) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean validateUserName(String userName) {
		// TODO Auto-generated method stub
		String pattern = "[A-Z]{1}[a-z]{2,10}[0-9]{2,}";
		
		return Pattern.matches(pattern,userName);
	}

	@Override
	public boolean validatePassword(String passWord) {
		// TODO Auto-generated method stub
		String pattern = "[A-Z]{1,3}[a-z]{2,10}[@#&%$!_()][0-9]{4,}";
		
		return Pattern.matches(pattern,passWord);
	}

	@Override
	public void addAccount(Account acc) throws WalletException {
		// TODO Auto-generated method stub
		dao.addAccount(acc);
	}

	@Override
	public double deposit(String name, double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(name, amount);
	}

	@Override
	public double withdraw(String name, double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(name, amount);
	}

	@Override
	public void fundTransfer(String name, String toUserName, double amount) throws WalletException {
		// TODO Auto-generated method stub
		dao.fundTransfer(name, toUserName, amount);
	}

	@Override
	public List<String> printTransactions(String name) throws WalletException {
		// TODO Auto-generated method stub
		return dao.printTransactions(name);
	}

	@Override
	public boolean validateLogin(String user, String password) {
		// TODO Auto-generated method stub
		return dao.validateLogin(user, password);
	}

	@Override
	public double showBalance(String username) {
		// TODO Auto-generated method stub
		return dao.showBalance(username);
	}
}
