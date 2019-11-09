package com.lti.service;

import com.lti.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService
{
	AccountDaoImpl accountDao;
	public AccountServiceImpl() 
	{
		accountDao = new AccountDaoImpl();
	}
	
	@Override
	public void withdrawAmount(long accountNumber, double amount) 
	{
		
		accountDao.beginTransaction();
		accountDao.withdrawFromAccount(accountNumber, amount);
		accountDao.commitTransaction();
	}

}
