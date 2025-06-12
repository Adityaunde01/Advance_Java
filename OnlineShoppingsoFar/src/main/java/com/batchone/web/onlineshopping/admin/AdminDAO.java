package com.batchone.web.onlineshopping.admin;

public interface AdminDAO {
	public Admin getAdmin(String name,String password);
	public void addCategory(String name,String description, String imageUrl);
	public void addProduct(Integer catId, String name,String description, String imageUrl,Double price);
	public void updateCategory(Integer catId,String name,String description, String imageUrl);
	public void close();
}
