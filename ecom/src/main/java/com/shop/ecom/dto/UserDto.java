package com.shop.ecom.dto;


public class UserDto {
	private Integer id;

	private String  name;


	private String password;


	private String emial;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(Integer id, String name, String password, String emial) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", emial=" + emial + "]";
	}
}
