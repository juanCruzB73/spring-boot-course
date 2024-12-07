package com.springbootfirst.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.springbootfirst.springbootfirst.Alien;

@SpringBootApplication
public class SpringbootfirstApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootfirstApplication.class, args);
	
		Laptop lap = context.getBean(Laptop.class);
		lap.compile();
	}

}
