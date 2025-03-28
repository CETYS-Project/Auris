package com.cetys.loading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.model.User;
import com.cetys.loading.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public Object[] getAllUsers() {
        return userService.getAllUsers().toArray();
    }

    @GetMapping("/{id}")
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(Long id, User userDetails) {
        return userService.updateUser(id, userDetails);
    }

}
