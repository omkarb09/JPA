package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import com.lti.model.Users;

import com.lti.service.UserService;



public class Main {
	
	private static UserService service = null;
	
	static
	{
		service = new UserService();
	}

	public static void main(String[] args) {
		String username;
		String password;
		String firstname;
		String lastname;
		String mobilenumber;
		
		Scanner sc = new Scanner(System.in);
		
		Users user = new Users();
		
		byte ch=0;
		
		System.out.println("Login Page");
		System.out.println("Enter username:");
		username= sc.next();
		
		System.out.println("Enter password:");
		password= sc.next();
		
		boolean result=service.checkLogin(username, password);
		System.out.println(result);
		
		if(result)
		{
			do{
				System.out.println("Users CRUD DEMO");
				System.out.println("1.Insert\n2.Display\n3.Delete\n4.Update\n5.Exit\n");
				System.out.println("Enter your choice:");
				ch=sc.nextByte();
				
				switch (ch) 
				{
					case 1://Add
						System.out.println("Insert Functionality");
						System.out.println("Enter username:");
						username= sc.next();
						
						System.out.println("Enter password:");
						password= sc.next();
						
						System.out.println("Enter firstname:");
						firstname= sc.next();
						
						System.out.println("Enter lastname:");
						lastname= sc.next();
						
						System.out.println("Enter mobilenumber:");
						mobilenumber= sc.next();
						
						user= new Users(username,password,firstname,lastname,mobilenumber);
						
						boolean result3=service.addUser(user);
						
						if(result3)
						{
							System.out.println("Users object with id "+username+" saved\n");
						}

					break;
					
					case 2://Display 
						List<Users> users=service.findAllUsers();
						
						for(Users u : users)
						{
							System.out.println(u);
						}
					break;
					
					case 3://Delete
						
						System.out.println("Enter username:");
						username= sc.next();
						boolean result2=service.removeUser(username);
						if(result2)
						{
							System.out.println("User deleted");
						}
						
					break;
					
					case 4://Update
						
						System.out.println("Enter username:");
						username= sc.next();
						
						System.out.println("Enter username:");
						password= sc.next();
						
						System.out.println("Enter firstname:");
						firstname= sc.next();
						
						System.out.println("Enter lastname:");
						lastname= sc.next();
						
						System.out.println("Enter mobilenumber:");
						mobilenumber= sc.next();
						
						user= new Users(username,password,firstname,lastname,mobilenumber);
						user=service.updateUser(user);
						
						System.out.println(user);
					break;
					
					case 5:
						System.out.println("Exiting .........");
					break;
					
					default:
						System.out.println("Invalid Choice");
					break;
				}
				
			}while(ch!=5);
		}
		
		else
		{
			System.out.println("Invalid Login");
		}
		
		
		
		sc.close();

	}

}
