package com.batchone.web.onlineshopping.cart;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppigCart implements Cart {
	ArrayList<CartProduct>  products = null;
	
	public ShoppigCart() {
		products = new ArrayList<>();
	}
	
	@Override
	public void addToCart(CartProduct product) {
		products.add(product);
	}

	@Override
	public Iterator<CartProduct> getFromCart() {
		// TODO Auto-generated method stub
		
		
		return products.iterator();
	}

}
