package com.backend.example.BeansIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplicationBeans {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(ExampleApplicationBeans.class, args);

		MyFirstService myFirstService=ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		//System.out.println(myFirstService.getProp());
		//System.out.println(myFirstService.getCustomProp());



	}

}
