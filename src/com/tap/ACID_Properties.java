package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ACID_Properties {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final Scanner sc = new Scanner(System.in);
	private static final String UPDATE_BALANCE = "UPDATE `employee` SET `salary` = `salary` + ? WHERE `name` = ?";
	private static Connection connection;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			connection.setAutoCommit(false);
			transaction();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void transaction() throws SQLException {
		System.out.println("Enter the  Sender Name");
		String send = sc.next();

		System.out.println("Enter the  Receiver Name");
		String rec = sc.next();

		System.out.println("Enter the Amount");
		int Amount = sc.nextInt();

		int sender_res=updateBalance(send, -Amount);
		int receiver_res=updateBalance(rec, Amount);

		if (isConfirm(sender_res,receiver_res)) {
			connection.commit();
			System.out.println("Transaction Success");
		} else {
			connection.rollback();
			System.out.println("Transaction Failed");
		}

	}

	public static int updateBalance(String user, int Amount) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(UPDATE_BALANCE);
		pstmt.setInt(1, Amount);
		pstmt.setString(2, user);

		return pstmt.executeUpdate();
	}

	public static boolean isConfirm(int sender_res,int receiver_res ) {
		System.out.println("Do you want to continue the transcation?(Yes/No)");
		String choice = sc.next();
		return sender_res ==1 && receiver_res == 1 && choice.equalsIgnoreCase("Yes");
	}


}
