package springmvcproject.one.conf;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springmvcproject.one.bean.User;

@Configuration
@ComponentScan(basePackages = "springmvcproject.one")
public class ApplicationConfigurator {

	
    @Bean
    public User objUser() {
        return new User();
    }

    @Bean
    public SessionFactory sessionFactory() {
    	SessionFactory f =  new HibernateConf().sessionFactory();
System.out.println("*******"+f);
return f;
    }
}
