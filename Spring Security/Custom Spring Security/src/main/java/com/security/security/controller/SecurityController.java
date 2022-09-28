package com.security.security.controller;

import com.security.security.model.User;
import com.security.security.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/welcome")
    public String showPage(){
       return "Hello";
    }

    @PostMapping("/add")
    public void addUser(){
        UserService u1 = new UserService();
        u1.addUser();
    }
}
