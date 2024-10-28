package com.example.security_service.dao;

import com.example.security_service.entity.UserCredentials;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends MongoRepository<UserCredentials,Integer> {

    Optional<UserCredentials> findByName(String name);
}
