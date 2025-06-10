package com.batchone.web.onlineshopping.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class AdminDAOImpl  implements AdminDAO{

	Connection dbConnection = null;
	PreparedStatement psAddCategory = null;
	PreparedStatement psAddProduct= null;
	PreparedStatement psUpdateCategory = null;
	
	
	
	public AdminDAOImpl(ServletContext getSerContext) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ServletContext app = getSerContext;
			String db_url = app.getInitParameter("db_url"); 
			String user = app.getInitParameter("user");
			String pass = app.getInitParameter("pass");
			dbConnection = DriverManager.getConnection(db_url,user,pass);
			
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed");
			throw new ServletException("Connection failed", e);
		}
		
	}

	
	@Override
	public Admin getAdmin(String name, String password) {
		if (name.equals("root") && password.equals("my-secret-pw")) {
			return new Admin(name,password,"Admin1234");
		}
		return null;
	}

	@Override
	public void addCategory(String name,String description, String imageUrl) {
		try {
			psAddCategory = dbConnection.prepareStatement("insert into  categories set name=?,description=?,image_url=? ");
			psAddCategory.setString(1, name);
			psAddCategory.setString(2, description);
			psAddCategory.setString(3, imageUrl);
			psAddCategory.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProduct(Integer catId, String name,String description, String imageUrl,Double price) {
		try {
			psAddProduct = dbConnection.prepareStatement("insert into  products set name=?,description=?,price=?,image_url=?,category_id=?");
			psAddProduct.setString(1, name);
			psAddProduct.setString(2, description);
			psAddProduct.setDouble(3, price);
			psAddProduct.setString(4, imageUrl);
			psAddProduct.setInt(5, catId);
			psAddProduct.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void updateCategory(Integer catId,String name,String description, String imageUrl) {
		try {
			psUpdateCategory = dbConnection.prepareStatement("Update  categories  set name=?,description=?,image_url=? where id=?");
			psUpdateCategory.setString(1, name);
			psUpdateCategory.setString(2, description);
			psUpdateCategory.setString(3, imageUrl);
			psUpdateCategory.setInt(4, catId);
			psUpdateCategory.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void close() {
		try {
			if(psAddCategory != null)
				psAddCategory.close();
			if(psAddProduct != null)
				psAddProduct.close();
			if(psUpdateCategory != null)
				psUpdateCategory.close();
			if(dbConnection != null)
				dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
