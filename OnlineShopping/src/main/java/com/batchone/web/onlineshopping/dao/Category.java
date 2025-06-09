package com.batchone.web.onlineshopping.dao;

public class Category {
	int categoryId;
	String catagoryName;
	String categoryDesc;
	String categoryImage;
	
	
	
	public Category() {
		
	}


	public Category(int categoryId, String catagoryName, String categoryDesc, String categoryImage) {
	
		this.categoryId = categoryId;
		this.catagoryName = catagoryName;
		this.categoryDesc = categoryDesc;
		this.categoryImage = categoryImage;
	}
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	
}
