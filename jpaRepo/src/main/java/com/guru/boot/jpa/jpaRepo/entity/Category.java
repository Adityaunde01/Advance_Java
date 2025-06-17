package com.guru.boot.jpa.jpaRepo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "id")
	Integer id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "description")
	String desc;
	
	@Column(name = "image_url")
	String imageUrl;
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}


	public Category(Integer id, String name, String desc, String imageUrl) {
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
