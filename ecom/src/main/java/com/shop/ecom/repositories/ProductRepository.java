package com.shop.ecom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.ecom.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select obj from Product obj where category_id=:catId")
	public List<Product> getProductByCategory(@Param("catId")Integer catId);
}
