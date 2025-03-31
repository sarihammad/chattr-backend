package com.chattr.user.service;

import com.chattr.user.dto.CreateUserRequest;
import com.chattr.user.entity.User;
import com.chattr.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // Hash later!
                .build();
        return userRepository.save(user);
    }

    public boolean verifyCredentials(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}