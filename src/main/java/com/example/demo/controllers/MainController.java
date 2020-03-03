package com.example.demo.controllers;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/")
    public List<User> getAll(){
        List<User> all = userDAO.findAll();
        return all;
//        List<User> users = new A
    }

    @PostMapping("/")
    public void create(@RequestBody  User user){
        userDAO.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userDAO.deleteById(id);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id){
        return userDAO.findById(id).orElse(null);
    }

    @GetMapping("/gt/{value}")
    public List<User> getGt(@PathVariable int value){
//        return userDAO.findAllByAgeGreaterThan(value);
        List<User> res = new ArrayList<>();
        List<User> all = userDAO.findAll();
        all.forEach(user -> {
            if (user.getAge() > value) {
                res.add(user);
            }
        });
        return res;
    }
}
