package org.secondspring.second;

import org.secondspring.second.bean.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfigurator {

	
	@Bean
	public Animal objAnimal() {
		Animal animal = new Animal();
		
		animal.setAge(10);
		animal.setName("anu");
		animal.setWeight(1.1f);
		animal.setType("mamal");
		return animal;
	}
}
