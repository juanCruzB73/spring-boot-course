package com.jwtDemo.jwtDemo.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @PostMapping(value = "demo")
    public String welcome(){
        return "this is a welcome message";
    }

}
