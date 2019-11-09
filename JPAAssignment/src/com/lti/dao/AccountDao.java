package com.lti.dao;

import com.lti.model.Account;

public interface AccountDao {
	public void withdrawFromAccount(long accountNumber,double amount);
	//public void depositToAccount(double amount);
	//public void transferToAccount(Account sender, Account receiver, double amount);
}
