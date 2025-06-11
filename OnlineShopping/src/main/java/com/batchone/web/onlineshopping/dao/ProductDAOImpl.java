package com.batchone.web.onlineshopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletContext;

public class ProductDAOImpl implements ProductDAO {
	
	
	Connection dbConnection = null;	
	PreparedStatement psCategory = null;
	
	
	
	
	public ProductDAOImpl(ServletContext application ) {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = application.getInitParameter("db_url"); 
			String user = application.getInitParameter("user");
			String pass = application.getInitParameter("pass");
			dbConnection = DriverManager.getConnection(db_url,user,pass);
		
			System.out.println("Db Connected succesfully");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Db connectoin failed" + e.getMessage());
		}
	}




	@Override
	public Iterator<Product> getProducts(String custId ) {
	
		ResultSet resultProduct = null;
		ArrayList<Product> allProducts = new ArrayList<>();
		try {
			psCategory = dbConnection.prepareStatement("select * from products  where category_id=?");
			psCategory.setString(1, custId);
			resultProduct = psCategory.executeQuery();
			while(resultProduct.next()) {
			int pid = resultProduct.getInt(1);
			String pName = resultProduct.getString(2);
			String pDesc = resultProduct.getString(3);
			Double pPrice = resultProduct.getDouble(4);
			String pImage =	resultProduct.getString(5);
			Product current = new Product(pid, pName, pDesc, pPrice, pImage);
			allProducts.add(current);
			}
			return allProducts.iterator();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultProduct != null)
					resultProduct.close();
			}
			 catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	@Override
	public void close() {
		try {
			if(psCategory != null)
				psCategory.close();
			if(dbConnection != null)
				dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
