package com.assignment.two;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface DatabaseUtil {
	
	public static void createTable(Scanner sc, Connection dbConnection) throws SQLException, InputMismatchException {
		
		int choice  = 1;
		System.out.println("Enter the Table Name");
		String tableName = sc.nextLine();
		StringBuilder query = new StringBuilder("");
		query.append("CREATE TABLE ");
		query.append(tableName);
		query.append("( ");
		while(choice == 1) {
			//sc.nextLine();
			System.out.println("Please Enter the Column Name");
			String columnName = sc.nextLine();
			System.out.println("select Datatype of column: "+ columnName);
			System.out.println("1. INT"
					+ "2. FLOAT"
					+ "3. VARCHAR");
			int datatype = sc.nextInt();
			switch (datatype) {
			case 1:
				query.append(" " + columnName + " INT,");
				break;
			case 2:
				query.append(" " + columnName + " FLOAT,");
				break;
			case 3:
				System.out.println("enter size of VARCHAR");
				Integer size = sc.nextInt();
				query.append(" " + columnName + " VARCHAR(");
				query.append(size.toString());
				query.append("),");
				break;
			default:
				System.out.println("invalid Datatype");
				break;
			}
			
			
			System.out.println("Enter 1 to continue adding Columns");
			choice = sc.nextInt();
		}
		query.deleteCharAt(query.length()-1);
		query.append(");");
		PreparedStatement psCreateTable = dbConnection.prepareStatement(query.toString());
		psCreateTable.executeUpdate();
		System.out.println("Created Table Succsfully");
		
	}
	
	public static void print(Scanner sc, Connection dbConnection) throws SQLException, InputMismatchException {
		
	}

}
