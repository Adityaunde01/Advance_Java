package com.shop.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ecom.dto.UserDto;
import com.shop.ecom.entity.User;
import com.shop.ecom.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<UserDto> getAllUsers(){
		return  userRepo.findAll().stream().map(user->{
			UserDto userdto = new UserDto(user.getId(),user.getName(),user.getEmial());
			
			return userdto;
		}).collect(Collectors.toList());
	}
	
	public User getUserNameNPass(String name, String pass) {
		 User user = userRepo.getUserNamePass(name, pass);
		 if(user == null)
			 throw new RuntimeException("User not found");
		return user;
	}
	
}
