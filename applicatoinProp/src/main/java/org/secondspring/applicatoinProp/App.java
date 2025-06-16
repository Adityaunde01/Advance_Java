package org.secondspring.applicatoinProp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.secondspring.applicatoinProp.conf.ApplicationConf;
import org.secondspring.applicatoinProp.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConf.class);
       
       SessionFactory hiberFactory = (SessionFactory)context.getBean("sessionFactory");
       Session hiberSession = hiberFactory.openSession();
       User user = 
       
    }
}
