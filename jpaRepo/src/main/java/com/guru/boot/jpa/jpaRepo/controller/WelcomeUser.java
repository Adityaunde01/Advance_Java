package com.guru.boot.jpa.jpaRepo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guru.boot.jpa.jpaRepo.dto.UserDTO;
import com.guru.boot.jpa.jpaRepo.services.UserDAO;

@RestController
public class WelcomeUser {

	@Autowired
	 private UserDAO user;
	
	@GetMapping("/user/{id}")
	public UserDTO getUser(@PathVariable int id) {
		return user.getUserById(id);
	}
}
