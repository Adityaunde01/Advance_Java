package com.shop.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecom.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
