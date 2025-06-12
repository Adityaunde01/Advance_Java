package com.batchone.web.onlineshopping.cart;

import java.util.Iterator;

public interface Cart {
	
 public void addToCart(CartProduct product);
 public Iterator<CartProduct> getFromCart();
}
