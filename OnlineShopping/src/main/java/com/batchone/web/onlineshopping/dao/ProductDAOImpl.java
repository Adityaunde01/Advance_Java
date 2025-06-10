package com.batchone.web.onlineshopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductDAOImpl implements ProductDAO {
	
	
	
	
	PreparedStatement psCategory = null;
	
	@Override
	public Iterator<Product> getProducts(String custId, Connection dbConnection) {
	
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
				if(psCategory != null)
						psCategory.close();
			}
			 catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
}
