package com.shop.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecom.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
