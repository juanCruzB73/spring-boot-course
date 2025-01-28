package com.springcourse.awsDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "Hello friend";
    }
    @GetMapping("about")
    public String aboutMachine(){
        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String architecture = System.getProperty("os.arch");
        String javaVersion = System.getProperty("java.version");
        String user = System.getProperty("user.name");

        return "OS: "+os+" VERSION: "+version+" ARCHITECTURE: "+architecture+" JAVA VERSION: "+javaVersion+" USER: "+user;

    }

}
