package com.lti.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;

public class Main {

	public static void main(String[] args) {
		int authorId;
		String firstName;
		String middleName;
		String lastName;
		String phoneNo;
		Scanner sc = new Scanner(System.in);
		
		Author author = new Author();
		
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_AS");
		EntityManager em =factory.createEntityManager();
		byte ch=0;
		do{
			System.out.println("Author CRUD DEMO");
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.Find\n5.Exit\n");
			System.out.println("Enter your choice:");
			ch=sc.nextByte();
			
			switch (ch) 
			{
				case 1:
					System.out.println("Insert Functionality");
					System.out.println("Enter ID:");
					authorId= sc.nextInt();
					
					System.out.println("Enter First Name:");
					firstName= sc.next();
					
					System.out.println("Enter Middle Name:");
					middleName= sc.next();
					
					System.out.println("Enter Last Name:");
					lastName= sc.next();
					
					System.out.println("Enter Phone number:");
					phoneNo= sc.next();
					
					author= new Author(authorId,firstName,middleName,lastName,phoneNo);
					em.getTransaction().begin();
					em.persist(author);
					em.getTransaction().commit();
					
					System.out.println("Author object with id "+authorId+" saved\n");
					
				break;
				
				case 2:
					System.out.println("Update Functionality");
					System.out.println("Enter ID:");
					authorId= sc.nextInt();
					
					author= em.find(Author.class, authorId);
					System.out.println("Enter First Name:");
					firstName= sc.next();
					
					System.out.println("Enter Middle Name:");
					middleName= sc.next();
					
					System.out.println("Enter Last Name:");
					lastName= sc.next();
					
					System.out.println("Enter Phone number:");
					phoneNo= sc.next();
					
					author= new Author(authorId,firstName,middleName,lastName,phoneNo);
					em.getTransaction().begin();
			        em.merge(author);
			        em.getTransaction().commit();
			        
			        System.out.println("Student object with id "+authorId+" updated\n");
				break;
				
				case 3:
					System.out.println("Delete Functionality");
					System.out.println("Enter ID:");
					authorId= sc.nextInt();
					author = em.find(Author.class,authorId);
					em.getTransaction().begin();
					em.remove(author);
					em.getTransaction().commit();
					System.out.println("Student object with id "+authorId+" deleted\n");
				break;
					
				case 4:
					System.out.println("Find Functionality");
					System.out.println("Enter ID:");
					authorId= sc.nextInt();
					
					author = em.find(Author.class,authorId);
					System.out.println(author);
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

}
