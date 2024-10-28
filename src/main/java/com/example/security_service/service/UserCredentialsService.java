package com.example.security_service.service;

import com.example.security_service.dao.UserCredentialsRepository;
import com.example.security_service.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    jwtService jwtservice;

    public UserCredentials register(UserCredentials userCredentials) {
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        return userCredentialsRepository.save(userCredentials);
    }

    public boolean verifyToken(String token) {
        jwtservice.validateToken(token);
        return true;
    }

    public String generatetoken(String name) {
        return jwtservice.createtoken(name);
    }
}
