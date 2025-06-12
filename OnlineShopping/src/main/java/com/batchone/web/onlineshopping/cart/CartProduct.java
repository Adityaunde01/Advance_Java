package com.batchone.web.onlineshopping.cart;

public class CartProduct {
	Integer categoryId;
	Integer productId;
	Float Price;
	
	
	
	public CartProduct() {
		super();
	}

	public CartProduct(Integer categoryId, Integer productId, Float price) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
		Price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}
	
	
	
}
