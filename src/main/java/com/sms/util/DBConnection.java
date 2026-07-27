package com.sms.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DBConnection {
	
	private static final String URL="jdbc:mysql://localhost:3306/student_management_system";
	private static final String USERNAME="root";
	private static final String PASSWORD="Root@123";
	
	private DBConnection() {
		//Prevent Object Creation;
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
	};
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}
		catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Unable to connect to Database", e);
		}
		
	}

}
