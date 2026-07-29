package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
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

	@Override
	public List<Student> getAllStudents() {
		 List<Student> students=new ArrayList<>();
		   String sql="SELECT * from student";
		   try(
			   Connection con=DBConnection.getConnection();
			   PreparedStatement ps=con.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery()){
			   while(rs.next()) {
				   Student student=new Student();
				   
				   student.setId(rs.getInt("id"));
				   student.setName(rs.getString("name"));
				   student.setAge(rs.getInt("age"));
				   student.setEmail(rs.getString("email"));
				   student.setCity(rs.getString("city"));
				   
				   
				   students.add(student);
		   };
		   }catch(SQLException e) {
			   System.out.println(e);
			   
		   }
		   
		   return students;
	}
	
	
	@Override
	public Student getStudentById(int id) {

	    String sql = "SELECT * FROM student WHERE id = ?";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        // Set the value of '?'
	        ps.setInt(1, id);

	        // Execute the query
	        ResultSet rs = ps.executeQuery();

	        // Check if a record exists
	        if (rs.next()) {

	            Student student = new Student();

	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setAge(rs.getInt("age"));
	            student.setEmail(rs.getString("email"));
	            student.setCity(rs.getString("city"));

	            return student;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Return null if no student is found
	    return null;
	}
	

	@Override
	public boolean updateStudent(Student student) {

	    String sql = "UPDATE student SET name=?, age=?, email=?, city=? WHERE id=?";

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ) {

	        ps.setString(1, student.getName());
	        ps.setInt(2, student.getAge());
	        ps.setString(3, student.getEmail());
	        ps.setString(4, student.getCity());
	        ps.setInt(5, student.getId());

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	
	@Override
	public boolean deleteStudent(int id) {
		String sql="DELETE FROM student WHERE ID=?";
		try(
				Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(sql);
				){
			ps.setInt(1,id);
			int rows=ps.executeUpdate();
			return rows>0;
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return false;
		
	}



}
