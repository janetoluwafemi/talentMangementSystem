package com.personal.project.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SelectingTalentsUserForEmploymentResponse {
    @Id
    private String talentUserId;
    private String message;
}
