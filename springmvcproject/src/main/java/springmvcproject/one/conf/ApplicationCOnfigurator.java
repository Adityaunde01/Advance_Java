package springmvcproject.one.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springmvcproject.one.bean.User;

@Configuration
@ComponentScan(basePackages = "springmvcproject.one.bean")
public class ApplicationCOnfigurator {
	
	@Bean
	public User objUser() {
		return new User();
	}
	
	
}
