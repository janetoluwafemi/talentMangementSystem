package com.personal.project.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("talentUser")
public class TalentUsers {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean isLogin;
    private String yearsOfExperience;
    private String talents;
}
