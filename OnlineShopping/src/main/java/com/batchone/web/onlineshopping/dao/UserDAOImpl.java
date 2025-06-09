package com.batchone.web.onlineshopping.dao;

public class UserDAOImpl implements UserDao {

	@Override
	public User getUser(int uid, String name, String email, String password) {
		User user = new User(uid, name, email, password);
		return user;
	}

}
