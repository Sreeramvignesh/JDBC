package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CRUD2 {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		   
		   Statement stmt = con.createStatement();
		   
		   String INSERT="INSERT into employee(id,name,email,department,salary) values(8,'salman','salman@gmail.com','IT',25000)";
		   int res =stmt.executeUpdate(INSERT);
			System.out.println(res);
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
