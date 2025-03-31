package com.chattr.auth.client;

import com.chattr.auth.dto.CreateUserRequest;
import com.chattr.auth.dto.VerifyUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", path = "/api/users")
public interface UserClient {

    @PostMapping("/create")
    void createUser(@RequestBody CreateUserRequest request);

    @PostMapping("/verify")
    boolean verifyUser(@RequestBody VerifyUserRequest request);
}