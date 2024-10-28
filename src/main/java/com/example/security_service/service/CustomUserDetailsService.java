package com.example.security_service.service;

import com.example.security_service.dao.UserCredentialsRepository;
import com.example.security_service.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials>user=userCredentialsRepository.findByName(username);
      return  user.map(CustomUserDetails :: new).orElseThrow(()->new UsernameNotFoundException("Username/password not valid!"));
    }
}
