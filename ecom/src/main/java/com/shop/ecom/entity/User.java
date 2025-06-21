package com.shop.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String  name;


	@Column(name = "password")
	private String password;


	@Column(name = "email")
	private String emial;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String password, String emial) {
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
