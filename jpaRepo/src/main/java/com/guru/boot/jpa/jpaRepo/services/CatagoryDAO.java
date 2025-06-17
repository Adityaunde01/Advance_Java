package com.guru.boot.jpa.jpaRepo.services;

import java.util.Iterator;

import com.guru.boot.jpa.jpaRepo.dto.CategoryDTO;

public interface CatagoryDAO {
		Iterator<CategoryDTO> getAllCategories();
		CategoryDTO getCAtegoryById(Integer Id);
}
