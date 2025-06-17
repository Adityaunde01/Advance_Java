package com.guru.boot.jpa.jpaRepo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guru.boot.jpa.jpaRepo.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
}
