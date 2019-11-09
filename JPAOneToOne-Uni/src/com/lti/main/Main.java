package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		Student student = new Student(33,"Mike",65.7);
		Address address = new Address("Mumbai","MH","400600");
		
		student.setAddress(address);
		entityManager.getTransaction().begin();
		entityManager.persist(address);
		entityManager.persist(student);
		entityManager.getTransaction().commit();

	}

}
