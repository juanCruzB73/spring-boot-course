package com.security.springSecurity.controller;


import com.security.springSecurity.model.AuthResponse;
import com.security.springSecurity.model.LoginRequest;
import com.security.springSecurity.model.RegisterRequest;
import com.security.springSecurity.service.JwtService;
import com.security.springSecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @PostMapping("auth/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
            return ResponseEntity.ok(userService.login(request));
    }
}
