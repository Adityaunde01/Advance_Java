package springmvcproject.one.conf;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springmvcproject.one.bean.User;

@Configuration
@ComponentScan(basePackages = "springmvcproject.one")
public class ApplicationConfigurator {
	
	@Autowired
	private HibernateConf hibernateConf; // ✅ Inject HibernateConf
	
	@Bean
	public User objUser() {
		return new User();
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		SessionFactory sessionFactory = hibernateConf.sessionFactory(); // ✅ Use injected instance
		System.out.println("SessionFactory bean created: " + sessionFactory);
		return sessionFactory;
	}
}