package com.sms.service;

import java.util.List;

import com.sms.model.Student;

public interface StudentService {
	boolean addStudent(Student student);

	List<Student> getAllStudents();
	
	Student getStudentById(int id);
	
	boolean updateStudent(Student updatedStudent);
	boolean deleteStudent(int id);
}
