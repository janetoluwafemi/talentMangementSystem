package com.personal.project.dtos.requests;

import lombok.Data;

@Data
public class SelectingTalentsUserForEmploymentRequest {
    private String email;
    private String talent;
    private String yearsOfExperience;
}
