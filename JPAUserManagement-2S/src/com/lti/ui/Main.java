package com.lti.ui;

import com.lti.service.UserServiceImpl;

public class Main {
	private static UserServiceImpl service;
	static{
		service = new UserServiceImpl();
	}
	public static void main(String[] args) {
		boolean loginStatus = service.checkLogin("AW204_PC1", "India@123");
		if(loginStatus){
			System.out.println("Sucessful login... show the menu");
		}else{
			System.out.println("Invalid login...");
		}
	}
}
