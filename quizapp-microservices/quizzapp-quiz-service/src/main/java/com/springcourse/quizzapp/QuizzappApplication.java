package com.springcourse.quizzapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizzappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzappApplication.class, args);
	}

}
