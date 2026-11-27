package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class CRUD7 {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		// establish the connection
			Connection con = DriverManager.getConnection(URL,USER, PASSWORD);
			
		String INSERT="INSERT into employee(id,name,email,department,salary)"+"values(?,?,?,?,?)";
			
		
					String choice=null;
					// create a statement
					PreparedStatement ptsmt = con.prepareStatement(INSERT);
				
				do
				{
					
					
					//inputs
						 System.out.println("Enter the id:");
						 int id=sc.nextInt();
						 System.out.println("Enter the name:");
						 String name=sc.next();
						 System.out.println("Enter the email:");
						 String email=sc.next();
						 System.out.println("Enter the department:");
						 String department=sc.next();
						 System.out.println("Enter the salary:");
						 int salary=sc.nextInt();
						 
						 ptsmt.setInt(1 ,id);
						 ptsmt.setString(2, name);
						 ptsmt.setString(3, email);
						 ptsmt.setString(4, department);
						 ptsmt.setInt(5, salary);
						 // execute the query
						 ptsmt.addBatch();  
						 System.out.println("Do you want to Enter the Employee? Yes/No");
						 choice=sc.next();
						 
				}
				while(choice.equalsIgnoreCase("Yes"));
				
				int[] res = ptsmt.executeBatch();                
				
				for (int i : res) {
					System.out.println(res);
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
