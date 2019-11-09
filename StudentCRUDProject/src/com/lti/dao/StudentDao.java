package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao 
{
	public int createStudent(Student student);
	
	public Student readStudentByRollNo(int rollNo);
	
	public List<Student> readAllStudents();
	
	public Student updateStudent(Student student);
	
	public int deleteStudent(int rollNo);
	
	public void beginTransaction();
	
	public void commitTransaction();
	
	public void rollbackTransaction();
	
	public List<Student> readStudentByScore(double min, double max);
	
	public List<Student> readStudentByName(String name);
}
