package com.example.security_service.controller;

import com.example.security_service.entity.UserCredentials;
import com.example.security_service.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialController {
    @Autowired
    UserCredentialsService userCredentialsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public UserCredentials register(@RequestBody UserCredentials userCredentials){
        return userCredentialsService.register(userCredentials);
    }

    @PostMapping("/validate/user")
    public String validateUser(@RequestBody UserCredentials userCredentials) {
//        System.out.println(userCredentials.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getName(), userCredentials.getPassword()));
        System.out.println(authentication.isAuthenticated());
        if (authentication.isAuthenticated()) {
            return userCredentialsService.generatetoken(userCredentials.getName());
        }
        return null;
    }

    @GetMapping("validate/token")
    public boolean validateToken(@RequestParam String token){
        return userCredentialsService.verifyToken(token);
    }
}
