package com.shop.ecom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.ecom.entity.Category;

public interface CategoryReopsitory extends JpaRepository<Category, Integer> {
	
	@Query("select obj.id from Category obj")
	public List<Integer> getAllCategoryId();

}
