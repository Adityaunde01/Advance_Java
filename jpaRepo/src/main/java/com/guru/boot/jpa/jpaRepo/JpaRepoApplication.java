package com.guru.boot.jpa.jpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guru.boot.jpa.jpaRepo.repository.UserRepository;

@SpringBootApplication(scanBasePackages = {"com.guru.boot.jpa.jpaRepo.services"})
@EntityScan(basePackages = {"com.guru.boot.jpa.jpaRepo.entity"})
@EnableJpaRepositories(basePackages = {"com.guru.boot.jpa.jpaRepo.repository"})
public class JpaRepoApplication implements CommandLineRunner {
		
	@Autowired
	UserRepository user;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaRepoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");
		System.out.println(user.findById(1));
		
	}

}
