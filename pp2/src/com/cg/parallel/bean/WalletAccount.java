package com.cg.parallel.bean;

public class WalletAccount {

	private String userName;
	private String walletId;
	private double balance;
	private String password;
	
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}

	public WalletAccount(String userName,String walletId, double balance,
			String password) {
		super();
		this.userName = userName;
		this.walletId= walletId;
		this.balance = balance;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "WalletAccount [userName=" + userName + ", walletId=" + walletId
				+ ", balance=" + balance + ", password=" + password + "]";
	}

}
