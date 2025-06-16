package springmvcproject.one.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	String id;
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "name")
	String name;
	@Column(name = "email")
	String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "User [username=" + username + ", Password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	

}
