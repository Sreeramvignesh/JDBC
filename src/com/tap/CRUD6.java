package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD6 {
	
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	public static final Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
			try {
				//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Establish a Connection 
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String UPDATE="UPDATE employee SET salary = salary + ? WHERE department = ?";
			
			// create a statement
			PreparedStatement ptmst = con.prepareStatement(UPDATE);
			
			// Enter the inputs
			System.out.println("Enter the increment amount");
			int inc=sc.nextInt();
			System.out.println("Enter the depatment");
			String dept=sc.next();
			ptmst.setInt(1, inc);
			ptmst.setString(2 , dept);
			
			// execute the query
			int res = ptmst.executeUpdate();
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
