package com.batchone.web.onlineshopping.dao;

import java.sql.PreparedStatement;
import java.util.Iterator;

public interface CategoryDAO {
	
	public Iterator<Category> getAllCategory(PreparedStatement psCategory);
}
