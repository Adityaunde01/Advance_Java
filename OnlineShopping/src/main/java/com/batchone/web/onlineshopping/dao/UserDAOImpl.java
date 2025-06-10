package com.batchone.web.onlineshopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

public class UserDAOImpl implements UserDao {

	Connection dbConnection = null;
	PreparedStatement psAuth = null;
	
	public UserDAOImpl(ServletContext getSerContext) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ServletContext app = getSerContext;
			String db_url = app.getInitParameter("db_url"); 
			String user = app.getInitParameter("user");
			String pass = app.getInitParameter("pass");
			dbConnection = DriverManager.getConnection(db_url,user,pass);
			psAuth = dbConnection.prepareStatement("Select * from users where name=? and password=?");
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed");
			throw new ServletException("Connection failed", e);
		}
	}
	
	
	@Override
	public User getUser( String userName,String password) {
		
		
		ResultSet result = null;
		try {
			psAuth.setString(1, userName);
			psAuth.setString(2, password);
			result = psAuth.executeQuery();
		
			if(result.next()) {
				Integer uid = result.getInt(1);
				String name = result.getString(2);
				String email = result.getString(3);
				String pass = result.getString(4);
				User user = new User(uid, name, email, pass);
				
				
				return user;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(result != null) {
					result.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public void close() {
		try {
			if(psAuth != null)
				psAuth.close();
			if(dbConnection != null)
				dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
