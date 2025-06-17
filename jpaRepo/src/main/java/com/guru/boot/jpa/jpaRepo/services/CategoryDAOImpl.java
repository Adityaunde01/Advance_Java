package com.guru.boot.jpa.jpaRepo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.boot.jpa.jpaRepo.dto.CategoryDTO;
import com.guru.boot.jpa.jpaRepo.entity.Category;
import com.guru.boot.jpa.jpaRepo.repository.CategoryRepository;



@Service
public class CategoryDAOImpl implements CatagoryDAO {

	@Autowired
	private CategoryRepository category;
	
	@Override
	public Iterator<CategoryDTO> getAllCategories() {
		Iterator<Category> categories = category.findAll().iterator();
		List<CategoryDTO> categorieDTOs = new ArrayList<CategoryDTO>();
		while(categories.next()!= null) {
			CategoryDTO categorydto = new CategoryDTO();
			BeanUtils.copyProperties(categories.next(),categorydto);
			categorieDTOs.add(categorydto);
		}
		
		return categorieDTOs.iterator();
	}

	@Override
	public CategoryDTO getCAtegoryById(Integer Id) {
		Optional<Category> optCategory = category.findById(Id);
		if(!optCategory.isEmpty()) {
			CategoryDTO catdto = new CategoryDTO();
			BeanUtils.copyProperties(optCategory.get(), catdto);
			return catdto;
		}
			return null;
			
	}

}
