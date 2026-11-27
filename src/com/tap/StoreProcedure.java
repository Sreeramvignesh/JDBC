package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


public class StoreProcedure {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			CallableStatement call = connection.prepareCall("{call count_emp(?,?) }");
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the Department");
			String dept=sc.next();
			call.setString(1,dept);
			call.registerOutParameter(2,Types.INTEGER);
			boolean res = call.execute();
			int count = call.getInt(2);
			System.out.println(res);
			System.out.println(count);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
