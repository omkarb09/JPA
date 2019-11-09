package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager=factory.createEntityManager();
		
		Student student = new Student();
		student.setStudentName("Ron");
		student.setAvgScore(70.75);
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		student.setAvgScore(75.75);
		entityManager.getTransaction().commit();
		
		System.out.println("Student entered is : \n"+student);
		
	
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		System.out.println("Student entered is removed from database \n");
		
	}

}
