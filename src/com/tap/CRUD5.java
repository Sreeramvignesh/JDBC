package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD5 {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish a Connection 
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String SELECT="SELECT * from employee where department=?";
			// create a statement
			PreparedStatement pstmt = con.prepareStatement(SELECT);
			// Enter the inputs
			System.out.println("Enter a Department");
			String dept=sc.next();
			pstmt.setString(1, dept);
			// execute the query 
			ResultSet res = pstmt.executeQuery();
			
			while (res.next() == true) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String Email = res.getString("Email");
				String Department = res.getString("Department");
				int Salary = res.getInt("Salary");

				System.out.println(id + " " + name + " " + Email + " " + Department + " " + Salary);
			}
			
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
