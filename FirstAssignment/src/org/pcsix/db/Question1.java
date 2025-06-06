package org.pcsix.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Question1 {





	public static void main(String[] args) {



		try(Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchone", "root", "cdac");
				Scanner sc  = new Scanner(System.in);
				){
			while(true) {
				System.out.println("________________________________________________________");
				System.out.println("Write a Java Console Application that is used to perform the following task\r\n"
						+ "1. Register a User\r\n"
						+ "2. List All Users based on City\r\n"
						+ "3. Update Password of a User\r\n"
						+ "4. Display user information based on User Name\r\n"
						+ "0. to Exit\n");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					Questoin1Util.addUser(dbConnection, sc);

					break;
				case 2:
					Questoin1Util.printUserByCity(dbConnection, sc);
					break;
				case 3:
					Questoin1Util.updatePass(dbConnection, sc);
					break;
				case 4:
					Questoin1Util.printUserDetails(dbConnection, sc);
					break;
				case 0:
					System.out.println("exiting....");
					return;
				default:
					System.out.println("invald choice enter valid option");
					break;
				}
			}




		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
