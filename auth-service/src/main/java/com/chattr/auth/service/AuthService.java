package com.chattr.auth.service;

import com.chattr.auth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String username, String password) {
        // TODO: validate with user-service
        return jwtUtil.generateToken(username);
    }

    public String signup(String username, String password) {
        // TODO: create user in user-service
        return jwtUtil.generateToken(username);
    }
}