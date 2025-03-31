package com.chattr.user.controller;

import com.chattr.user.dto.CreateUserRequest;
import com.chattr.user.dto.VerifyUserRequest;
import com.chattr.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
        return "User created!";
    }

    @PostMapping("/verify")
    public boolean verifyUser(@RequestBody VerifyUserRequest request) {
        return userService.verifyCredentials(request.getUsername(), request.getPassword());
    }
}