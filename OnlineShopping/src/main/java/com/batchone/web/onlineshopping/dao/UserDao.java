package com.batchone.web.onlineshopping.dao;

public interface UserDao {
	
	public User getUser( String name, String password);

	void close();
}
