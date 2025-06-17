package com.guru.boot.jpa.jpaRepo.services;

import java.util.Iterator;

import com.guru.boot.jpa.jpaRepo.dto.UserDTO;


public interface UserDAO {
	Iterator<UserDTO> getAllUsers();
	UserDTO getUserById(Integer Id);

}
