package com.lti.service;

import com.lti.model.Account;

public interface AccountService {
	public void withdrawAmount(long accountNumber,double amount);
	//public void depositAmount(double amount);
	//public void transferAmount(Account sender, Account receiver, double amount);
}
