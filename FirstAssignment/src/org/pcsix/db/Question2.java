package org.pcsix.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question2 {
	
	public static void printUsers(ResultSet result) throws SQLException{
		while(result.next()) {
			for(int i =1; i<=6;i++) {
				System.out.print(result.getString(i)+ " ");
			}
			System.out.println();
		}
	}
	
	public static void addUser(ResultSet result) throws SQLException {
		
		System.out.println("Enter Name");
		System.out.println("Enter UserName");
		System.out.println("Enter Password");
		System.out.println("Enter email");
		System.out.println("Enter city");
	}

	
	
	
	public static void main(String[] args) {
		
		
		
		try(Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "cdac");
				Statement stSelect = dbConnection.createStatement();
					ResultSet result  = stSelect.executeQuery("select * from batchone.users");){
						printUsers(result);
						System.out.println("connection successful");
						
			
		} catch (SQLException e) {
				e.printStackTrace();
		} 
	}
}
