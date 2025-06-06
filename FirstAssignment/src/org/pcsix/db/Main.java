package org.pcsix.db;

import java.sql.Connection;
import java.sql.DriverManager;				
import java.sql.ResultSet;
import java.sql.SQLException;	
import java.sql.Statement;	
	
public class Main {
	
	

	public static void main(String[] args) {
		Connection dbConnection = null;
		Statement stSelect = null;
		ResultSet result = null;
		
		
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "cdac");
			stSelect = dbConnection.createStatement();
			result = stSelect.executeQuery("select * from batchone.users");
			System.out.println("connection successful");
			while(result.next()) {
				for(int i =1; i<=6;i++) {
					System.out.print(result.getString(i)+ " ");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			try {
				if (dbConnection != null) {
					 dbConnection.close();
				}
			} catch (SQLException e2) {
				System.err.println(e2.getMessage());
			}
		}
	}

}
