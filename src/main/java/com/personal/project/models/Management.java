package com.personal.project.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("management")
public class Management {
    @Id
    private String id;
    private List<TalentUsers> talentUsersList = new ArrayList<>();
}
