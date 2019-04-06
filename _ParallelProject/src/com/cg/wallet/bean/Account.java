package com.cg.wallet.bean;

public class Account {
	private int accId;
	private String accName;
	private double accBalance;
	private String userName;
	private String passWord;
	static int begin=100;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accName,String userName, String passWord) {
		super();
		this.accId = ++begin;
		this.accName = accName;
		this.accBalance = 1000.00;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getAccId() {
		return begin;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accName=" + accName + ", accBalance=" + accBalance + ", userName="
				+ userName + ", passWord=" + passWord + "]";
	}	
}



