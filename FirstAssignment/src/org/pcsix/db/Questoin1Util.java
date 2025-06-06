package org.pcsix.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface Questoin1Util {

	public static void printAllUsers(Connection dbConnection) throws SQLException{
		Statement stSelect = dbConnection.createStatement();
		ResultSet result  = stSelect.executeQuery("select * from users");
		while(result.next()) {
			for(int i =1; i<=6;i++) {
				System.out.print(result.getString(i)+ " ");
			}
			System.out.println();
		}
	}


	public static void updatePass(Connection dbConnection ,Scanner sc) throws SQLException {
		PreparedStatement psUpdate = dbConnection.prepareStatement("update users set password=? where username=?");
		System.out.println("Enter UserName whose password to be updated: ");
		String name = sc.nextLine();
		System.out.println("Update the Password");
		String password = sc.nextLine();


		psUpdate.setString(1, password);
		psUpdate.setString(2, name);

		psUpdate.executeUpdate();
		System.out.println("Updated succesfully");

	}

	public static void printUserByCity(Connection dbConnection ,Scanner sc) throws SQLException {
		PreparedStatement psSelect = dbConnection.prepareStatement("select * from users where city=?");
		sc.nextLine();
		System.out.println("enter City to see uses: ");
		String city = sc.nextLine();


		psSelect.setString(1, city);

		ResultSet result =  psSelect.executeQuery();
		while(result.next()) {
			for(int i =1; i<=6;i++) {
				System.out.print(result.getString(i)+ " ");
			}
			System.out.println();
		}

		System.out.println("details shown succesfully");

	}

	public static void printUserDetails(Connection dbConnection ,Scanner sc) throws SQLException {
		PreparedStatement psSelect = dbConnection.prepareStatement("select * from users where username=?");

		System.out.println("enter username to see user details: ");
		String username = sc.nextLine();


		psSelect.setString(1, username);

		ResultSet result =  psSelect.executeQuery();
		while(result.next()) {
			for(int i =1; i<=6;i++) {
				System.out.print(result.getString(i)+ " ");
			}
			System.out.println();
		}

		System.out.println("details shown succesfully");

	}

	public static void addUser(Connection dbConnection,Scanner sc) throws SQLException,InputMismatchException {
		PreparedStatement psInsert = dbConnection.prepareStatement("insert into users values(?,?,?,?,?,?)");
		System.out.println("Enter Id");
		int count = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter UserName");
		String userName = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		System.out.println("Enter email");
		String email = sc.nextLine();
		System.out.println("Enter city");
		String city = sc.nextLine();
		psInsert.setInt(1, count++);
		psInsert.setString(2, name);
		psInsert.setString(3, userName);
		psInsert.setString(4, password);
		psInsert.setString(5, city);
		psInsert.setString(6, email);

		psInsert.executeUpdate();
		System.out.println("added succesfully");

	}

}
