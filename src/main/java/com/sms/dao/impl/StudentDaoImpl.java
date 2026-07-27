package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sms.dao.StudentDao;
import com.sms.model.Student;
import com.sms.util.DBConnection;

public class StudentDaoImpl implements StudentDao {

	
	@Override
	public boolean addStudent(Student student) {

	    String sql = "INSERT INTO student(id,name,age,email,city) VALUES(?,?,?,?,?)";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setInt(1, student.getId());
	        ps.setString(2, student.getName());
	        ps.setInt(3, student.getAge());
	        ps.setString(4, student.getEmail());
	        ps.setString(5, student.getCity());

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
