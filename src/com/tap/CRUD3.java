package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD3 {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			Statement stmt=con.createStatement();
			
			String UPDATE="UPDATE employee SET salary=salary+5000 WHERE department='IT'";
			int res = stmt.executeUpdate(UPDATE);
			System.out.println(res);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
}
