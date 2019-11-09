package com.lti.service;

import java.util.List;

import com.lti.dao.StudentDao;
import com.lti.dao.StudentDaoImpl;
import com.lti.model.Student;

public class StudentServiceImpl implements StudentService 
{
	private StudentDao studentDao;
	
	public StudentServiceImpl() 
	{
		studentDao = new StudentDaoImpl();
	}
	
	@Override
	public boolean addStudent(Student student) 
	{
		studentDao.beginTransaction();
		int result = studentDao.createStudent(student);
		if(result == 1)
		{
			studentDao.commitTransaction();
			return true;
		}
		else
		{
			studentDao.rollbackTransaction();
			return false;
		}
	}

	@Override
	public List<Student> findAllStudents() 
	{
		
		return studentDao.readAllStudents();
	}

	@Override
	public Student findStudentByRollNumber(int rollNumber) 
	{
		Student student =  studentDao.readStudentByRollNo(rollNumber);
		return student;
	}

	@Override
	public Student modifyStudent(Student student) 
	{
		studentDao.beginTransaction();
		Student student2 = studentDao.updateStudent(student);
		studentDao.commitTransaction();
		return student2;
	}

	@Override
	public boolean removeStudent(int rollNumber) 
	{
		studentDao.beginTransaction();
		int result = studentDao.deleteStudent(rollNumber);
		if(result == 1)
		{
			studentDao.commitTransaction();
			return true;
		}
		else
		{
			studentDao.rollbackTransaction();
			return false;
		}
		
	}

	@Override
	public List<Student> findStudentByScore(double min, double max) {
		
		return studentDao.readStudentByScore(min, max);
	}

	@Override
	public List<Student> findStudentByName(String name) {
		
		return studentDao.readStudentByName(name);
	}

}
