package com.tap;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class BlobClob {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";;
	private static final String USER ="root";
	

	public static void main(String[] args) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish a connection
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
		// create a statement
			PreparedStatement pstmt = connection.prepareStatement("UPDATE employee SET db=? WHERE id =?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a Id:");
			pstmt.setInt(2, sc.nextInt());
			String path="D:\\Eclipse\\jdbc\\img\\UFC.jpg";
			
			FileInputStream fis = new FileInputStream(path);
			pstmt.setBinaryStream(1, fis);
			
			int i = pstmt.executeUpdate();
			System.out.println(i);
			
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
