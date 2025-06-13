package org.secondspring.second;

import org.secondspring.second.bean.Animal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(Appconfigurator.class)){
        	Animal animl = (Animal)context.getBean("objAnimal");
        	System.out.println(animl);
        }
    }
}
