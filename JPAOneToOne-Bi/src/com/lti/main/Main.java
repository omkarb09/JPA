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
		
		Student student = new Student(5,"Michael",85.7);
		Address address = new Address("Mumbai","MH","400600");
		
		student.setAddress(address);
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		
		
		Student student2 = new Student(67,"Mike",99.7);
		Address address2 = new Address("Delhi","Delhi","200600");
		student2.setAddress(address2);
		entityManager.getTransaction().begin();
		entityManager.persist(student2);
		entityManager.getTransaction().commit();
		/*Student student2 = entityManager.find(Student.class, student.getStudentId());
		System.out.println(student2);
		System.out.println(student2.getAddress());*/
	}

}
