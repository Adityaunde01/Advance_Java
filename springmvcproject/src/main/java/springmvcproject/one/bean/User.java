package springmvcproject.one.bean;

import org.springframework.stereotype.Component;

public class User {
	String username;
	String Password;
	String name;
	String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String name, String email) {
		super();
		this.username = username;
		Password = password;
		this.name = name;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", Password=" + Password + ", name=" + name + ", email=" + email + "]";
	}
	

}
