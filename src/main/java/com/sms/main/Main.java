package com.sms.main;
import java.util.List;
import java.util.Scanner;

import com.sms.model.Student;
import com.sms.service.impl.StudentServiceImpl;



import com.sms.service.StudentService;


public interface Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			  System.out.println("\n======================================");
	            System.out.println("     STUDENT MANAGEMENT SYSTEM");
	            System.out.println("======================================");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Search Student");
	            System.out.println("4. Update Student");
	            System.out.println("5. Delete Student");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice=sc.nextInt();
	            
	            switch(choice) {
	            	
	            case 1:
	            	System.out.println("Enter id");
	            	int id=sc.nextInt();
	            	sc.nextLine();
	            	
	            	System.out.print("Enter Name: ");
	            	String name=sc.nextLine();
	            	
	            	System.out.println("Enter your age:");
	            	int age=sc.nextInt();
	            	sc.nextLine();
	            	
	            	 System.out.print("Enter Email: ");
	            	    String email = sc.nextLine();
	            	    
	            	 System.out.println("Enter City:");
	            	 String city=sc.nextLine();
	            	 
	            	 Student student=new Student(id,name,age,email,city);
	            	 
	            	 StudentService studentService=new StudentServiceImpl();
	            	 
	            	 boolean status=studentService.addStudent(student);
	            	 
	            	  if (status) {
	            	        System.out.println("✅ Student Added Successfully");
	            	    } else {
	            	        System.out.println("❌ Failed to Add Student");
	            	    }

	            	break;
	            	
	            case 2:
	            	 StudentService service=new StudentServiceImpl();
	            	List<Student> students = service.getAllStudents();

	                if (students.isEmpty()) {
	                    System.out.println("No Students Found");
	                } else {

	                    System.out.println("\n===== Student List =====");

	                    for (Student student1 : students) {
	                        System.out.println(student1);
	                    }
	                }

	            	break;
	            case 3:

	                System.out.print("Enter Student ID: ");
	                int searchId = sc.nextInt();
	                StudentService service1=new StudentServiceImpl();

	                Student student1 = service1.getStudentById(searchId);

	                if (student1 != null) {
	                    System.out.println("\n===== Student Details =====");
	                    System.out.println(student1);
	                } else {
	                    System.out.println("Student not found.");
	                }

	                break;
	            case 4:
                    System.out.println("Update Student Selected");
                    break;

                case 5:
                    System.out.println("Delete Student Selected");
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid Choice!");
	            }
		}
	}
}
