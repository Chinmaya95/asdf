package com.cg.parallel.bean;

public class TransactionBean {

	
	private String transactionId;
	private String type;
	private String transactionDateTime;
	private String transactionComment;
	
	public TransactionBean(String transactionId, String type, String transactionDateTime,
			String transactionComment) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.transactionDateTime = transactionDateTime;
		this.transactionComment = transactionComment;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionComment() {
		return transactionComment;
	}

	public void setTransactionComment(String transactionComment) {
		this.transactionComment = transactionComment;
	}

	@Override
	public String toString() {
		return "TransactionBean [transactionId=" + transactionId + ", type=" + type + ", transactionDateTime="
				+ transactionDateTime + ", transactionComment=" + transactionComment + "]";
	}
	
	
}
