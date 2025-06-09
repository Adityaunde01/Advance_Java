package com.assignment.two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
	
	
	
	
	
	public static void main(String[] args) {
		final String DB_URI = "jdbc:mysql://localhost:3306/onlineshopping";
		final String userName = "root";
		final String passWord = "my-secret-pw";
		try(Connection dbConnection = DriverManager.getConnection(DB_URI, userName, passWord);
				Scanner sc = new Scanner(System.in);) {
				//DatabaseUtil.createTable(sc, dbConnection);
			System.out.println("connection succesfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
