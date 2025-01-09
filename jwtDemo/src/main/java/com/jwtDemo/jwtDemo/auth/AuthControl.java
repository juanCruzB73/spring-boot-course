package com.jwtDemo.jwtDemo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControl {

    @PostMapping
    public String login(){
        return "login succesfull";
    }

    @PostMapping("/register")
    public String register(){
        return "Register succesfull";
    }


}
