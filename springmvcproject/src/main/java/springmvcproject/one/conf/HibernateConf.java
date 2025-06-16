package springmvcproject.one.conf;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class HibernateConf {
	
		@Bean
		public SessionFactory sessionFactory() {
			return new Configuration().configure("hiber.conf.xml").buildSessionFactory();
		}
		
		

}
