package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD8 {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish the connection 
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String DELETE="DELETE from employee where id=?";
			//create the statement
			PreparedStatement ptsmt = con.prepareStatement(DELETE);
			
			//inputs
			 System.out.println("Enter the id:"); 
			 int id=sc.nextInt();
			 ptsmt.setInt(1,id);
			
			
			//execute the query 
			int res = ptsmt.executeUpdate();
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
