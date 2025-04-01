package com.cetys.loading.controller;

import com.cetys.loading.dto.request.UserDtoRequest;
import com.cetys.loading.dto.response.UserDtoResponse;
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
    public UserDtoResponse getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public UserDtoResponse createUser(UserDtoRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PutMapping("/{id}")
    public UserDtoResponse updateUser(Long id, UserDtoRequest userDetails) {
        return userService.updateUser(id, userDetails);
    }

}
