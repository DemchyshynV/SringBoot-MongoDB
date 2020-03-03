package com.example.demo.dao;

import com.example.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends MongoRepository<User, String> {
    List<User> findAllByAgeGreaterThan(int age);
}
