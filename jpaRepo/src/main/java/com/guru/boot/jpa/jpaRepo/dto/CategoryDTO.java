package com.guru.boot.jpa.jpaRepo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class CategoryDTO {
	Integer id;
	String name;
	String desc;
	String imageUrl;
	
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}


	public CategoryDTO(Integer id, String name, String desc, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.imageUrl = imageUrl;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", desc=" + desc + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
