package com.personal.project.dtos.responses;

import lombok.Data;

@Data
public class LogOutUserResponse {
    private boolean isLogin;
    private String message;
}
