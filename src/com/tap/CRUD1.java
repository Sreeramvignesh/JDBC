package com.tap;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class CRUD1 {
	
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String username = "root";

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded successfully");

			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is etablished");

			stmt = con.createStatement();

			String sql = "SELECT * FROM employee";

			res = stmt.executeQuery(sql);

			displayemployee(res);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			closedresources(con, stmt, res);
		}

	}

	public static void displayemployee(ResultSet res) throws SQLException {
		while (res.next() == true) {
			int id = res.getInt("id");
			String name = res.getString("name");
			String Email = res.getString("Email");
			String Department = res.getString("Department");
			int Salary = res.getInt("Salary");

			System.out.println(id + " " + name + " " + Email + " " + Department + " " + Salary);
		}
	}

	public static void closedresources(Connection con, Statement stmt, ResultSet res) {
		try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	
	
	
	

		


