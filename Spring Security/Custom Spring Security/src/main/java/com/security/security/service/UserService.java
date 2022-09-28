package com.security.security.service;

import com.security.security.model.User;
import com.security.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(){
        User u1 = new User();
        u1.setUsername("John");
        u1.setPassword("1234");
        u1.setEmail("john@gmail.com");
        u1.setRole("admin");
        userRepository.save(u1);
    }
}
