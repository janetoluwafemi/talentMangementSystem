package com.personal.project.dtos.requests;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PostTalentRequest {
    @Id
    private String id;
    private String email;
    private String yearsOfExperience;
    private String talents;
}
