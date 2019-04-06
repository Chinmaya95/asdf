package com.cg.wallet.exception;

public class WalletException extends Exception {

	String message;
	public WalletException() {
		// TODO Auto-generated constructor stub
	}
	public WalletException(String message) {
		super(message);
		//this.message = message;
	}
}
