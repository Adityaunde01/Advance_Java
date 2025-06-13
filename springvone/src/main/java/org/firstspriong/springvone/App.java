package org.firstspriong.springvone;

import org.firstspriong.springvone.bean.Animal;
import org.firstspriong.springvone.bean.Card;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      try(ClassPathXmlApplicationContext contect = new ClassPathXmlApplicationContext("springcong.xml")){
    	  Card card = (Card)contect.getBean("objCards");
    	  System.out.println(card);
    	  Animal animal = (Animal)contect.getBean("animalObj");
    	  System.out.println(animal);
      }
    }
}
