package com.shop.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ecom.entity.Category;
import com.shop.ecom.repositories.CategoryReopsitory;

@Service
public class CategoryService {
		@Autowired
		CategoryReopsitory categoryReop;
		
		public List<Category> getAllCategories(){
			
			return categoryReop.findAll();
		}
	
		public List<Integer> getCategoryIds(){
			
			return categoryReop.getAllCategoryId();
		}
		

	
}
