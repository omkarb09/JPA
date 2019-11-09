package com.lti.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private long transactionId;
	private double transactionAmount;
	
	@ManyToOne
	@JoinColumn(name="acc_id")
	private Account account;
	
	public Transaction() {
		super();
	}
	
	public Transaction(long transactionId, double transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount + "]";
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
