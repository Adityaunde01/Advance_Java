package com.guru.boot.jpa.jpaRepo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guru.boot.jpa.jpaRepo.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

}
