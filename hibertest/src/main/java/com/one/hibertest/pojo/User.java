package com.one.hibertest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="uid")
	Integer id;
	@Column(name="name")
	String name;
	@Column(name="password")
	String password;
	@Column(name="email")
	String email;
	@Column(name="city")
	String city;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String password, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.city = city;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", city=" + city
				+ "]";
	}

	
	
}
