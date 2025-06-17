package com.guru.boot.jpa.jpaRepo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.boot.jpa.jpaRepo.dto.UserDTO;
import com.guru.boot.jpa.jpaRepo.entity.Users;
import com.guru.boot.jpa.jpaRepo.repository.UserRepository;

@Service
public class UserDAOImpl implements  UserDAO{

	@Autowired
	UserRepository user;
	
	
	@Override
	public Iterator<UserDTO> getAllUsers() {
		Iterator<Users> users = user.findAll().iterator();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		while(users.next()!= null) {
			UserDTO userDto = new UserDTO();
			BeanUtils.copyProperties(users.next(),userDto);
			userDTOs.add(userDto);
		}
		
		return userDTOs.iterator();
	}

	@Override
	public UserDTO getUserById(Integer Id) {
		Optional<Users> optUsers = user.findById(Id);
		if(!optUsers.isEmpty()) {
			UserDTO userDto = new UserDTO();
			BeanUtils.copyProperties(optUsers.get(), userDto);
			return userDto;
		}
		
		
		
		return null;
	}

}
