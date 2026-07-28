package com.sms.dao;
import java.util.List;
import com.sms.model.Student;

public interface StudentDao {
	boolean addStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getStudentById(int id);
	
}
