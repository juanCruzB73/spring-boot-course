package com.springDemo;

import com.springDemo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Alien alien = (Alien) context.getBean("alien");

        alien.code();*/

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien alien = context.getBean(Alien.class);
        System.out.println(alien.getAge());
        alien.code();
    }
}
