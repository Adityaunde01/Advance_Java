package com.shop.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.ecom.configuration.UserPrinciple;
import com.shop.ecom.entity.User;
import com.shop.ecom.repositories.UserRepository;

@Service
public class MyUserDetailService  implements UserDetailsService{

	@Autowired
	 UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User user = userRepo.findByName(username);
		  if(user == null)
			  throw new UsernameNotFoundException("user not found with username: "+ username);
		  
		  
		  return  new UserPrinciple(user);
	}
  
}
