package com.batchone.web.onlineshopping.dao;

import java.util.Iterator;

public interface ProductDAO {
	
	public Iterator<Product> getProducts(String custId);
}
