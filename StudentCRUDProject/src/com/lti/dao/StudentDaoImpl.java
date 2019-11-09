package com.lti.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;

public class StudentDaoImpl implements StudentDao
{
	private EntityManager entityManager;
	
	public StudentDaoImpl() 
	{
		entityManager = JpaUtils.getEntityManager();
	}
	
	@Override
	public int createStudent(Student student) 
	{
		entityManager.persist(student);
		return 1;
	}

	@Override
	public Student readStudentByRollNo(int rollNo) {
		Student student = entityManager.find(Student.class, rollNo);
		return student;
	}

	@Override
	public List<Student> readAllStudents() {
		// TODO Auto-generated method stub
		/*Query query= entityManager.createQuery("From Student");
		List<Student> list = query.getResultList();*/
		
		TypedQuery<Student> tquery = entityManager.createQuery("Select s From Student s Order By s.rollNumber",Student.class);
		List<Student> list = tquery.getResultList();
		return list;
	}

	@Override
	public Student updateStudent(Student student) {
		Student student2 = entityManager.merge(student);
		return student2;
	}

	@Override
	public int deleteStudent(int rollNo) {
		Student student = readStudentByRollNo(rollNo);
		if(student!=null)
		{
			entityManager.remove(student);
			return 1;
		}
		return 0;
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}

	@Override
	public List<Student> readStudentByScore(double min, double max) {
		String query="Select s From Student s Where s.avgScore Between "+min+" and "+max+" ";
		//System.out.println(query);
		TypedQuery<Student> tquery = entityManager.createQuery(query, Student.class);
		List<Student> list =tquery.getResultList();
		return list;
	}

	@Override
	public List<Student> readStudentByName(String name) {
		String query="Select s From Student s Where s.studentName LIKE '%"+name+"' OR s.studentName LIKE '"+name+"%' OR s.studentName LIKE'%"+name+"%'";
		//System.out.println(query);
		TypedQuery<Student> tquery = entityManager.createQuery(query, Student.class);
		List<Student> list =tquery.getResultList();
		return list;
	}
	
}
