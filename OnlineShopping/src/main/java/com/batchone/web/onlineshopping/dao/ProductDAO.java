package com.batchone.web.onlineshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

public interface ProductDAO {
	
	

	public Iterator<Product> getProducts(String custId);
	public void close();
}
