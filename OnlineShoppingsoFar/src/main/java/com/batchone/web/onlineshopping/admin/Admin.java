package com.batchone.web.onlineshopping.admin;

public class Admin {
	String name;
	String password;
	String code;
	
	public Admin() {
		super();
	}

	public Admin(String name, String password, String code) {
		super();
		this.name = name;
		this.password = password;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + ", code=" + code + "]";
	}
	
	
	
}
