package com.shop.ecom.controllers;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecom.dto.UserDto;
import com.shop.ecom.entity.Category;
import com.shop.ecom.entity.Product;
import com.shop.ecom.entity.User;
import com.shop.ecom.service.CategoryService;
import com.shop.ecom.service.ProductService;
import com.shop.ecom.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	UserService users;
	
	@Autowired
	ProductService products;
	
	@Autowired
	CategoryService categories;
	
	@GetMapping("/users")
	public List<UserDto> getusers(){
		return users.getAllUsers();
	}
	
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user,HttpSession session) {
		User finduser = users.getUserNameNPass(user.getName(), user.getPassword());
		session.setAttribute("userObj", finduser);
		return finduser;
	}
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return products.getAllProducts();
	}
	
	@GetMapping("/category")
	public List<Category> getCategories(){
		return categories.getAllCategories();
	}
	
	@GetMapping("/categoryIds")
	public List<Integer> getCategoryId(){
		return categories.getCategoryIds();
	}
}
