package com.sms.main;

import java.util.List;
import java.util.Scanner;

import com.sms.model.Student;
import com.sms.service.StudentService;
import com.sms.service.impl.StudentServiceImpl;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        while (true) {

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

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                Student student = new Student(id, name, age, email, city);

                if (service.addStudent(student)) {
                    System.out.println("Student Added Successfully.");
                } else {
                    System.out.println("Failed to Add Student.");
                }

                break;

            case 2:

                List<Student> students = service.getAllStudents();

                if (students.isEmpty()) {
                    System.out.println("No Students Found.");
                } else {
                    System.out.println("\n===== Student List =====");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }

                break;

            case 3:

                System.out.print("Enter Student ID: ");
                int searchId = sc.nextInt();

                Student foundStudent = service.getStudentById(searchId);

                if (foundStudent != null) {
                    System.out.println("\n===== Student Details =====");
                    System.out.println(foundStudent);
                } else {
                    System.out.println("Student not found.");
                }

                break;

            case 4:

                System.out.print("Enter Student ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Student existingStudent = service.getStudentById(updateId);

                if (existingStudent == null) {

                    System.out.println("Student not found.");

                } else {

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New City: ");
                    String newCity = sc.nextLine();

                    Student updatedStudent = new Student(updateId, newName, newAge, newEmail, newCity);

                    if (service.updateStudent(updatedStudent)) {
                        System.out.println("Student Updated Successfully.");
                    } else {
                        System.out.println("Failed to Update Student.");
                    }
                }

                break;

            case 5:
            	System.out.println("Enter Student Id:");
            	int idVal=sc.nextInt();
            	sc.nextLine();
            	
            	Student deleteStudent=service.getStudentById(idVal);
            	 if (deleteStudent == null) {

            	        System.out.println("Student not found.");

            	    }else {
            	    	   System.out.println("\nStudent Details:");
            	           System.out.println(deleteStudent);
            	           
            	           System.out.print("\nAre you sure you want to delete? (Y/N): ");
            	           String choiceDelete = sc.nextLine();
            	           
            	           if (choiceDelete.equalsIgnoreCase("Y")) {

                               boolean deleted = service.deleteStudent(idVal);

                               if (deleted) {
                                   System.out.println("Student Deleted Successfully.");
                               } else {
                                   System.out.println("Failed to Delete Student.");
                               }

                           }else {
                        	   

                                   System.out.println("Delete Operation Cancelled.");

                               
                           }
            	    }
            	
            	
            	
                // We will implement this next.

                break;

            case 6:

                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

                break;

            default:

                System.out.println("Invalid Choice!");

            }
        }
    }
}