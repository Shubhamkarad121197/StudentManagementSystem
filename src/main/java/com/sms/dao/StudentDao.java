package com.sms.dao;
import java.util.List;
import com.sms.model.Student;

public interface StudentDao {
	boolean addStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getStudentById(int id);
	
	Student updateStudent(int id,String name,int age,String email,String city);

	boolean updateStudent(Student student);
	
	boolean deleteStudent(int id);
	
}
