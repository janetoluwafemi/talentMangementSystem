package com.personal.project.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class RegisterUserResponse {
    private String message;
    @Id
    private String id;
}
