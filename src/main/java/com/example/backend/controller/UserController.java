package com.example.backend.controller;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser) {
        return service.save(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public Object getUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser (@PathVariable Long id) throws Exception {
        return service.findById(id);         
    }
    

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        if(!service.existsById(id)){
            throw new UserNotFoundException(id);
        }
        service.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }



}