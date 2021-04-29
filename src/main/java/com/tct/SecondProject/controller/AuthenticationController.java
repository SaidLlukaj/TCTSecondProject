package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.User;
import com.tct.SecondProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public Map<String,String> register(@RequestBody User user){
        Map<String,String> response =new HashMap<>();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return response;

    }



}
