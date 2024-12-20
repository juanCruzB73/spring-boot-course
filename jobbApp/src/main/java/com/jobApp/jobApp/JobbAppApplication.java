package com.jobApp.jobApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jobApp.jobApp")
public class JobbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobbAppApplication.class, args);
	}

}
