package com.assignment.two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
	
	
	
	
	
	public static void main(String[] args) {
		try(Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchone", "root", "cdac");
				Scanner sc = new Scanner(System.in);) {
				DatabaseUtil.createTable(sc, dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
