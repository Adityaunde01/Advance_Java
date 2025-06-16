package firstMaven.hibernate;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import firstMaven.hibernate.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration hibernaConfiguration = null;
        //comment
        SessionFactory hibSessionFactory = null;
        
        Session hibernateSession = null;
        
        
        try(Scanner scanner = new Scanner(System.in)){
        	hibernaConfiguration = new Configuration();
        	
        	hibernaConfiguration.configure("hiber.cfg.xml");
        	hibSessionFactory = hibernaConfiguration.buildSessionFactory();
        	hibernateSession = hibSessionFactory.openSession();
        	User user =  hibernateSession.find(User.class, 2);
        	System.out.println(user);
        	
        	System.out.println("Enter Id:");
        	Integer id = scanner.nextInt();
        	 scanner.nextLine();
        	System.out.println("Enter name:");
        	String name = scanner.nextLine();
        	System.out.println("Enter email:");
        	String email = scanner.nextLine();
        	System.out.println("Enter passwoed:");
        	String password = scanner.nextLine();
        	
        	User user2 = new User(id, name, email, password);
        	
        	hibernateSession.beginTransaction();
        	hibernateSession.persist(user2);
        	hibernateSession.getTransaction().commit();
        	System.out.println(hibernateSession.find(User.class, id)+ " added succedfully");
        	hibernateSession.beginTransaction();
        	hibernateSession.remove(user);
        	hibernateSession.getTransaction().commit();
        	System.out.println("Removed  "+user);
        	
        
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {	
        	if(hibernateSession != null)
        		hibernateSession.close();
        	if(hibSessionFactory != null)
        		hibSessionFactory.close();
        }
        
    }
}
