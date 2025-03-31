package com.chattr.auth.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;;

@Getter
@AllArgsConstructor
public class AuthResponse {
    private String token;
}