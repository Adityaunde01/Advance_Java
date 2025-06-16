	package onlineshophibernate.api;
	
	import java.util.List;

import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

import onlineshophibernate.entity.Product;
import onlineshophibernate.entity.User;
	
	public class DataTest {
	
		public static void main(String[] args) {
				try(SessionFactory hiberfactory = new Configuration().configure("hiber.conf.xml").buildSessionFactory();) {
					Session hiberSession = hiberfactory.openSession();
					
					
					User user = hiberSession.createNamedQuery("getUser",User.class).setParameter("uid", 1).getSingleResult();
					List<Product> products = hiberSession.createNamedQuery("getByCatId",Product.class).setParameter("catID", 1).getResultList();
					System.out.println(user);
					System.out.println("_______________");
					products.forEach(System.out::println);
				} catch (Exception e) {
					
					System.out.print(e.getMessage());
					e.printStackTrace();
					// TODO: handle exception
				}
				
			
		}
	
	}
