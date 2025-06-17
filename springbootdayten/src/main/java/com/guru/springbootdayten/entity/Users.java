package com.guru.springbootdayten.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


@Entity

@Table(name = "users")
@NamedQueries({
	@NamedQuery(name="getAllUsers",query="from Users")
})
public class Users {
	@Id
	@Column(name="id")
	Integer id;
	@Column(name = "name")
	String name;
	@Column(name = "email")
	String email;
	@Column(name = "password")
	String password;
	 
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	

}
