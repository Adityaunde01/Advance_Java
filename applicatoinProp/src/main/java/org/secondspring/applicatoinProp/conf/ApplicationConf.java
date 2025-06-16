package org.secondspring.applicatoinProp.conf;

import org.hibernate.SessionFactory;
import org.secondspring.applicatoinProp.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConf {
 
	@Bean
	@Scope("prototype")
	public User objUser(@Value("${objUser.email}")String username,@Value("guur")String name, @Value("guur")String email, @Value("guur")String password) {
		return new User(username,name,email,password);
	}
	
	
}
