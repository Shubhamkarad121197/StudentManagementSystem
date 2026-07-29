package com.sms.service.impl;

import java.util.List;

import com.sms.dao.StudentDao;
import com.sms.dao.impl.StudentDaoImpl;
import com.sms.model.Student;
import com.sms.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }
    
    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
    
    @Override
    public Student getStudentById(int id) {
    	return studentDao.getStudentById(id);
    }

	
	@Override
	public boolean updateStudent(Student student) {
	    return studentDao.updateStudent(student);
	}
	
	@Override
	public boolean deleteStudent(int id) {
	    return studentDao.deleteStudent(id);
	}
}