package com.shop.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.ecom.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 
		public User findByName(String name);
	
		@Query("select obj from  User obj where obj.name=:name and obj.password=:pass")
		public User getUserNamePass(@Param("name")String name,@Param("pass")String pass);
}
