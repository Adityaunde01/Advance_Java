package com.shop.ecom.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ecom.entity.Product;
import com.shop.ecom.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	
	public List<Product> getAllProducts(){
		List<Product>productList = productRepo.findAll();
		if(productList == null){
			throw new RuntimeException("No produucts");
		}
		return productList;
	}
	
	public List<Product> getAllProducts(Integer catID){
		List<Product>productList = productRepo.getProductByCategory(catID);
		if(productList == null){
			throw new RuntimeException("No produucts");
		}
		return productList;
	}
	
	
	
}
