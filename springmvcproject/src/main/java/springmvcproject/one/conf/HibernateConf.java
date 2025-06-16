package springmvcproject.one.conf;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import springmvcproject.one.bean.User;

@PropertySource("classpath:application.properties")
public class HibernateConf {
		@Autowired
		org.springframework.core.env.Environment env;
		
		public SessionFactory sessionFactory() {
			Configuration hibenateConfig = new Configuration();
			Properties hiberprop = new Properties();
			
			hiberprop.setProperty("hibernate.connection.driver_class",env.getProperty("hibernate.connection.driver_class"));
			hiberprop.setProperty("hibernate.connection.username",env.getProperty("hibernate.connection.username"));
			hiberprop.setProperty("hibernate.connection.password",env.getProperty("hibernate.connection.password"));
			hiberprop.setProperty("hibernate.connection.url",env.getProperty("hibernate.connection.url"));
			hiberprop.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
			hiberprop.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
			hiberprop.setProperty("hibernate.connection.show_sql",env.getProperty("hibernate.connection.show_sql"));
			
			hibenateConfig.addProperties(hiberprop);
			
			hibenateConfig.addAnnotatedClass(User.class);
			System.out.println("configuration___________________________");
			return hibenateConfig.buildSessionFactory(); 
		}
		
		

}
