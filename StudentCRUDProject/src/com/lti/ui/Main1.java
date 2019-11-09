package com.lti.ui;

import java.util.List;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main1 
{
	private static StudentService service = null;
	
	static
	{
		service = new StudentServiceImpl();
	}
	public static void main(String[] args) 
	{
		/*Student student = new Student(10,"Vass",80.5);
		boolean result = service.addStudent(student);
		if(result)
		{
			System.out.println("Student is added in database");
			
			Student student2 = service.findStudentByRollNumber(student.getRollNumber());
			System.out.println(student);
		}*/
		
		List<Student>list = service.findAllStudents();
		
		for(Student s : list)
		{
			System.out.println(s);
		}

	}

}
