package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		Student student = new Student(1,"John",90.5);
		//JPA Api
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager =factory.createEntityManager();
		
		//To Add
		/*entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		System.out.println("Student object saved");*/
		
		//To Delete
		/*student = entityManager.find(Student.class,99);
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		System.out.println("Student object deleted");*/
		
		//To Update
		student = entityManager.find(Student.class,student.getRollNumber());
		System.out.println(student);
		
		student.setStudentName("John");
		student.setAvgScore(97);
		entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        
        System.out.println("Student object updated");
        System.out.println(student);
		
	}

}
