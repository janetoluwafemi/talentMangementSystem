package com.personal.project.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
