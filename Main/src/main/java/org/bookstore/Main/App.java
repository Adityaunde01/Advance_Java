package org.bookstore.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration hiberConfig = new Configuration();
        hiberConfig.configure("Main/src/hiber.cfg.xml");
        SessionFactory hiberSessionFactory = hiberConfig.buildSessionFactory();
        Session hiberSession = hiberSessionFactory.openSession();
        hiberSession.beginTransaction();
        
        
        //1) persist -> insert
        //2) load and find -> select
        //3) Remove -> delete
        //4) merge -> update
        
        
        Users objUser = new Users(121212, "test", "test@email", "test-password");
        
        hiberSession.persist(objUser);
        
        hiberSession.getTransaction().commit();
        
        System.out.println("Data inserted");
        
        
    }
}
