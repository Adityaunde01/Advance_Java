package com.shop.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="imageUrl")
	private String image_url;
	@Column(name="description")
	private String description;
}
