package com.personal.project.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PostTalentResponse {
            @Id
    private String id;
    private String message;
}
