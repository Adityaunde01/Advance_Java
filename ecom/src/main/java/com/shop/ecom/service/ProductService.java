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
		
		return productRepo.findAll();
	}
	
}
