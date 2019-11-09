package com.lti.dao;

import javax.persistence.EntityManager;

import com.lti.model.Account;
import com.lti.model.Transaction;
import com.lti.utils.JpaUtils;

public class AccountDaoImpl implements AccountDao
{
	private EntityManager entityManager;
	
	public void beginTransaction()
	{
		entityManager.getTransaction().begin();
	}
	
	public void commitTransaction()
	{
		entityManager.getTransaction().commit();
	}
	
	public void rollBackTransaction()
	{
		entityManager.getTransaction().rollback();
	}
	
	
	public AccountDaoImpl()
	{
		entityManager = JpaUtils.getEntityManager();
	}

	@Override
	public void withdrawFromAccount(long accountNumber, double amount) 
	{
		Account account= entityManager.find(Account.class, accountNumber);
		account.setAccountBalance(account.getAccountBalance()-amount);
		Transaction transaction = new Transaction(2,amount);
		transaction.setAccount(account);
		account.addTransaction(transaction);

	}
}
