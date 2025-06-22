package com.shop.ecom.dto;


public class UserDto {
	private Integer id;

	private String  name;

	private String emial;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(Integer id, String name, String emial) {
		super();
		this.id = id;
		this.name = name;
		this.emial = emial;
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


	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emial=" + emial + "]";
	}
}
