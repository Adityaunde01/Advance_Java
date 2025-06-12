package com.batchone.web.onlineshopping.dao;

public interface UserDao {
	
	public User getUser( String name, String password);
	public User registerUser(String name, String email, String password);
	void close();
}
