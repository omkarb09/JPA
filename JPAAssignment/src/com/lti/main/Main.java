package com.lti.main;

import com.lti.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		AccountServiceImpl service = new AccountServiceImpl();
		
		service.withdrawAmount(1000001, 6000);
		
	}

}
