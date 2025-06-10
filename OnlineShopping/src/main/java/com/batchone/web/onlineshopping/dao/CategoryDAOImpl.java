package com.batchone.web.onlineshopping.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletContext;




public class CategoryDAOImpl implements CategoryDAO {
	
	//private Iterator<Category> allCategories;
	Connection dbConnection = null;
	PreparedStatement psCategory = null; 
	
	public CategoryDAOImpl(ServletContext getservletContext) {
	ServletContext application = getservletContext;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = application.getInitParameter("db_url"); 
			String user = application.getInitParameter("user");
			String pass = application.getInitParameter("pass");
			dbConnection = DriverManager.getConnection(db_url,user,pass);
			psCategory = dbConnection.prepareStatement("Select * from categories");
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed" + e.getMessage());
		}
		
	}
	
	@Override
	public Iterator<Category> getAllCategory() {
		
		ResultSet resultCategory = null;
		ArrayList<Category> allCategory = new ArrayList<>();
		try {
			resultCategory = psCategory.executeQuery();
			while(resultCategory.next()) {
			int catId = resultCategory.getInt(1);
			String catName = resultCategory.getString(2);
			String catDesc = resultCategory.getString(3);
			String catImage =	resultCategory.getString(4);
			Category current = new Category(catId, catName, catDesc, catImage);
			allCategory.add(current);
			}
			return allCategory.iterator();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultCategory != null)
					resultCategory.close();
				if(psCategory != null)
					psCategory.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	
	public void close() {
		try {
			if(dbConnection != null)
				dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
