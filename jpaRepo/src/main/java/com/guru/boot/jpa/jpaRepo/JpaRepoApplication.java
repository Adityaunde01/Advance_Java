package com.guru.boot.jpa.jpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guru.boot.jpa.jpaRepo.repository.UserRepository;
import com.guru.boot.jpa.jpaRepo.services.CatagoryDAO;

@SpringBootApplication(scanBasePackages = {"com.guru.boot.jpa.jpaRepo"})
@EntityScan(basePackages = {"com.guru.boot.jpa.jpaRepo.entity","com.guru.boot.jpa.jpaRepo.controller"})
@EnableJpaRepositories(basePackages = {"com.guru.boot.jpa.jpaRepo.repository"})

public class JpaRepoApplication {
		

	
	public static void main(String[] args) {
		SpringApplication.run(JpaRepoApplication.class, args);
	}

	

}
