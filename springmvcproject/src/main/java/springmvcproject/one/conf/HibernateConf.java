package springmvcproject.one.conf;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import springmvcproject.one.bean.User;

@Component // ✅ Make it a Spring component
@PropertySource("classpath:application.properties")
public class HibernateConf {
	
	@Autowired
	private org.springframework.core.env.Environment env;

	public SessionFactory sessionFactory() {
		Configuration hibernateConfig = new Configuration();
		Properties hibernateProps = new Properties();

		hibernateProps.setProperty("hibernate.connection.driver_class", env.getProperty("hibernate.connection.driver_class"));
		hibernateProps.setProperty("hibernate.connection.username", env.getProperty("hibernate.connection.username"));
		hibernateProps.setProperty("hibernate.connection.password", env.getProperty("hibernate.connection.password"));
		hibernateProps.setProperty("hibernate.connection.url", env.getProperty("hibernate.connection.url"));
		hibernateProps.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProps.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProps.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql")); // ✅ Fixed property name

		hibernateConfig.addProperties(hibernateProps);
		hibernateConfig.addAnnotatedClass(User.class);
		
		System.out.println("SessionFactory configuration completed");
		return hibernateConfig.buildSessionFactory();
	}
}