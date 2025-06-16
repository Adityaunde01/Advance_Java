package com.one.hibertest;


import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;
import org.hibernate.Session;

import com.one.hibertest.pojo.Address;
import com.one.hibertest.pojo.HibernateUtil;
import com.one.hibertest.pojo.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        
        Session hibernateSession = null;
        
       
        try(Scanner scanner = new Scanner(System.in)){
        	
        	hibernateSession = HibernateUtil.getSessionFactory().openSession();
        	User user =  hibernateSession.find(User.class, 2);
        	System.out.println(user);
        	System.out.println("___________________________");
        	Query<User> query = hibernateSession.createQuery("select OBJECT(obj) from User obj where obj.city=:getCity", User.class);
        	query.setParameter("getCity", "san Diego");
        	List<User> list = query.getResultList();
        	list.forEach(System.out::println);
        	System.out.println("__________________________");
        	Query<Object[]> query2 = hibernateSession.createQuery("select obj.name,obj.password from User obj",Object[].class); 
        	List<Object[]> objList = query2.getResultList();
        	objList.forEach(obj->System.out.printf("%-20s %-15s\n", obj[0], obj[1]));
        	System.out.println("__________________________");
        	Query<Address> addressQuery =  hibernateSession.createNamedQuery("getAllAddresses",Address.class);
        	List<Address> listAddress =  addressQuery.getResultList();
        	listAddress.forEach(System.out::println);
        	System.out.println("__________________________");
        	Query<Address> getUserAddress = hibernateSession.createNamedQuery("getUserSpecificAddress", Address.class);
        	getUserAddress.setParameter("userID", 1);
            List<Address> listUserAddr = getUserAddress.getResultList();
            listUserAddr.forEach(System.out::println);
            System.out.println("__________________________");
          
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {	
        	if(hibernateSession != null)
        		hibernateSession.close();
        	if(HibernateUtil.getSessionFactory()!= null)
        		HibernateUtil.shutdown();
        }
    }
}
