package com.guru.springbootdayten;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.guru.springbootdayten.entity.Users;
import com.guru.springbootdayten.model.User;

@SpringBootApplication(scanBasePackages = "com.guru.springbootdayten.entity")
public class SpringbootdaytenApplication implements CommandLineRunner{
	
	@Autowired
	SessionFactory hibernateFactory;	
	
//	@Autowired
//	ApplicationContext contex;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdaytenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		try (Scanner sc = new Scanner(System.in);
				Session userSesion = hibernateFactory.openSession()){
				
//				System.out.println("Enter name:");
//				String name = sc.next();
//				System.out.println("Enter enmail:");
//				String email = sc.next();
//				System.out.println("Enter password:");
//				String password = sc.next();
//				System.out.println("Enter id:");
//				Integer id = sc.nextInt();
//				
//				Users user = new Users(id, name, email, password);
//				userSesion.beginTransaction();
//				userSesion.persist(user);
//				userSesion.getTransaction().commit();
				userSesion.beginTransaction();
				List<Users> iter = userSesion.createNamedQuery("getAllUsers", Users.class).getResultList();
				
				iter.forEach(System.out::println);
				System.out.println("User added");
				
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
