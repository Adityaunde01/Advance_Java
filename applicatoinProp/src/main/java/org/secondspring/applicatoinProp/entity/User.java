package org.secondspring.applicatoinProp.entity;

public class User {
	
	String userName;
	String email;
	String name;
	String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String email, String name, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
}
