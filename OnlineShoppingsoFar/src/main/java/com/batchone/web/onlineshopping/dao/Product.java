package com.batchone.web.onlineshopping.dao;

public class Product {
	private Integer pid;
	private String name;
	private String desc;
	private Double price;
	private String imgUrl;
	
	public Product() {
		super();
	}

	public Product(Integer pid, String name, String desc, Double price, String imgUrl) {
		super();
		this.pid = pid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
}
