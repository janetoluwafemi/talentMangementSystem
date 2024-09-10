package com.personal.project.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LogInUserResponse {
    @Id
    private String id;
    private boolean isLogin;
    private String message;
}
