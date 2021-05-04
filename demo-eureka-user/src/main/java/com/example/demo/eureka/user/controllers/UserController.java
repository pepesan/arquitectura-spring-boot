package com.example.demo.eureka.user.controllers;

import com.example.demo.eureka.user.dtos.ResponseUser;
import com.example.demo.eureka.user.entities.User;
import com.example.demo.eureka.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public List<User> getAll(){
        return userService.findAll();
    }
    @PostMapping("/")
    public User saveUser(@Valid @RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/{id}")
    public ResponseUser getUserById(@PathVariable("id") Long id){
        return userService.getUserByDeparment(id);
    }

}
