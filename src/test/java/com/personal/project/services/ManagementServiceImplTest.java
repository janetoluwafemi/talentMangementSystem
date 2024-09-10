package com.personal.project.services;

import com.personal.project.dtos.requests.LogInUserRequest;
import com.personal.project.dtos.requests.PostTalentRequest;
import com.personal.project.dtos.requests.RegisterUserRequest;
import com.personal.project.dtos.requests.SelectingTalentsUserForEmploymentRequest;
import com.personal.project.dtos.responses.LogInUserResponse;
import com.personal.project.dtos.responses.PostTalentResponse;
import com.personal.project.dtos.responses.RegisterUserResponse;
import com.personal.project.dtos.responses.SelectingTalentsUserForEmploymentResponse;
import com.personal.project.repositories.ManagementRepo;
import com.personal.project.repositories.TalentUsersRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ManagementServiceImplTest {
    @Autowired
    private TalentUsersService talentUsersService;
    @Autowired
    private TalentUsersRepo talentUsersRepo;
    @Autowired
    private ManagementService managementService;
    @Autowired
    private ManagementRepo managementRepo;
    @BeforeEach
    public void setUp() {
        talentUsersRepo.deleteAll();
    }
    @BeforeEach
    public void seUp() {
        managementRepo.deleteAll();
    }
    @Test
    public void testThatTalentUserCanBePicked() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Janet");
        registerUserRequest.setEmail("Janet@gmail.com");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("09087653271");
        RegisterUserResponse registerUserResponse = talentUsersService.registerUserResponse(registerUserRequest);
        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered user");

        LogInUserRequest logInUserRequest = new LogInUserRequest();
        logInUserRequest.setEmail("Janet@gmail.com");
        logInUserRequest.setPassword("1234");
        LogInUserResponse logInUserResponse = talentUsersService.logInUserResponse(logInUserRequest);
        assertThat(logInUserResponse.getMessage()).isEqualTo("Logged In Successfully");

        PostTalentRequest postTalentRequest = new PostTalentRequest();
        postTalentRequest.setTalents("Software Engineer");
        postTalentRequest.setEmail("Janet@gmail.com");
        postTalentRequest.setYearsOfExperience("5");
        PostTalentResponse postTalentResponse = talentUsersService.postTalentResponse(postTalentRequest);
        assertThat(postTalentResponse.getMessage()).isEqualTo("Talents Posted Successfully");

        SelectingTalentsUserForEmploymentRequest request = new SelectingTalentsUserForEmploymentRequest();
        request.setYearsOfExperience("5");
        SelectingTalentsUserForEmploymentResponse selectingTalentsUserForEmploymentResponse = managementService.selectingTalentsUserForEmploymentResponse(request);
        assertThat(selectingTalentsUserForEmploymentResponse.getMessage()).isEqualTo("User Picked Successfully");
    }
}