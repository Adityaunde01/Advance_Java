package com.batchone.web.onlineshopping.dao;

public interface UserDao {
	
	public User getUser(int uid, String name, String email, String password);
}
