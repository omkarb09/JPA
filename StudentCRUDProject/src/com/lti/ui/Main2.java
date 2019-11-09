package com.lti.ui;

import java.util.Scanner;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;



public class Main2 {

	private static StudentService service = null;
	
	static
	{
		service = new StudentServiceImpl();
	}
	
	public static void main(String[] args) 
	{
		int rollNumber;
		String studentName;
		double avgScore;
		Student student = null;
		byte ch=0;
		
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("Author CRUD DEMO");
			System.out.println("1.Add Student\n2.Read Student\n3.Modify Student\n4.Delete Student\n5.Exit\n");
			System.out.println("Enter your choice:");
			ch=sc.nextByte();
			
			switch (ch) 
			{
				case 1://Add Student
					System.out.println("Add Student Functionality");
					System.out.println("Enter Roll Number:");
					rollNumber= sc.nextInt();
					
					System.out.println("Enter Name:");
					studentName= sc.next();
					
					System.out.println("Enter Average Score:");
					avgScore= sc.nextDouble();
					
					student = new Student(rollNumber,studentName,avgScore);
					
					boolean result = service.addStudent(student);
					if(result)
					{
						System.out.println("Student is added in database");
						
						student = service.findStudentByRollNumber(student.getRollNumber());
						System.out.println(student+"\n");
					}

				break;
				
				case 2://Read Student
					System.out.println("Read Student Functionality");
					System.out.println("Enter Roll Number:");
					rollNumber= sc.nextInt();
					
					student = service.findStudentByRollNumber(rollNumber);
					System.out.println(student+"\n");
				break;
				
				case 3://Update Student
					System.out.println("Update Student Functionality");
					System.out.println("Enter Roll Number:");
					rollNumber= sc.nextInt();
					
					student = service.findStudentByRollNumber(rollNumber);
					if(student==null)
					{
						System.out.println("Student with roll number "+rollNumber+" not found\n");
					}
					else
					{
						System.out.println("Enter Name:");
						studentName= sc.next();
						
						System.out.println("Enter Average Score:");
						avgScore= sc.nextDouble();
						
						student = new Student(rollNumber,studentName,avgScore);
						student = service.modifyStudent(student);
						
						System.out.println("Modified student data");
						System.out.println(student+"\n");
						
					}
					
				break;
					
				case 4://Delete student
					System.out.println("Delete Student Functionality");
					System.out.println("Enter Roll Number:");
					rollNumber= sc.nextInt();
					
					student = service.findStudentByRollNumber(rollNumber);
					if(student==null)
					{
						System.out.println("Student with roll number "+rollNumber+" not found\n");
					}
					else
					{
						boolean result2=service.removeStudent(rollNumber);
						if(result2)
						{
							System.out.println("Student with roll number "+rollNumber+" deleted\n");
						}
					}
				break;
				
				case 5://Exit
					System.out.println("Exiting .........\n");
				break;
				
				default:
					System.out.println("Invalid Choice\n");
				break;
			}
			
		}while(ch!=5);
		
		sc.close();

	}

}
