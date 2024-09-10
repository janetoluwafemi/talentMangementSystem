package com.personal.project.dtos.requests;

import lombok.Data;

@Data
public class LogInUserRequest {
    private String email;
    private String password;
}
