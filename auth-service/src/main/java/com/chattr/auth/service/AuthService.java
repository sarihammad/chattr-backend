package com.chattr.auth.service;

import com.chattr.auth.client.UserClient;
import com.chattr.auth.dto.CreateUserRequest;
import com.chattr.auth.dto.VerifyUserRequest;
import com.chattr.auth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserClient userClient;

    public String signup(String username, String password) {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername(username);
        request.setPassword(password);
        userClient.createUser(request);
        return jwtUtil.generateToken(username);
    }

    public String login(String username, String password) {
        VerifyUserRequest request = new VerifyUserRequest();
        request.setUsername(username);
        request.setPassword(password);

        boolean isValid = userClient.verifyUser(request);
        if (!isValid) throw new RuntimeException("Invalid credentials");

        return jwtUtil.generateToken(username);
    }
}