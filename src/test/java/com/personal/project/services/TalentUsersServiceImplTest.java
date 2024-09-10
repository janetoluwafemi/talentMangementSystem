package com.personal.project.services;

import com.personal.project.Exceptions.InvalidEmailException;
import com.personal.project.Exceptions.InvalidPhoneNumberException;
import com.personal.project.Exceptions.UserAlreadyExistException;
import com.personal.project.dtos.requests.LogInUserRequest;
import com.personal.project.dtos.requests.LogOutUserRequest;
import com.personal.project.dtos.requests.PostTalentRequest;
import com.personal.project.dtos.requests.RegisterUserRequest;
import com.personal.project.dtos.responses.LogInUserResponse;
import com.personal.project.dtos.responses.LogOutUserResponse;
import com.personal.project.dtos.responses.PostTalentResponse;
import com.personal.project.dtos.responses.RegisterUserResponse;
import com.personal.project.repositories.TalentUsersRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TalentUsersServiceImplTest {
    @Autowired
    private TalentUsersService talentUsersService;
    @Autowired
    private TalentUsersRepo talentUsersRepo;

    @BeforeEach
    public void setUp() {
        talentUsersRepo.deleteAll();
    }

    @Test
    public void testThatTalentUsersCanRegister() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Talent");
        registerUserRequest.setEmail("talent@gmail.com");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("12345678900");
        RegisterUserResponse registerUserResponse = talentUsersService.registerUserResponse(registerUserRequest);
        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered user");
    }
    @Test
    public void testThatUserCanNotRegisterTwice() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Ife");
        registerUserRequest.setEmail("Ife@gmail.com");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("12345678900");
        RegisterUserResponse registerUserResponse = talentUsersService.registerUserResponse(registerUserRequest);
        assertThat(registerUserResponse.getMessage()).isEqualTo("Successfully registered user");

        registerUserRequest.setName("Ife");
        registerUserRequest.setEmail("Ife@gmail.com");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("12345678900");
        assertThrows(UserAlreadyExistException.class, () -> talentUsersService.registerUserResponse(registerUserRequest));
    }
    @Test
    public void testThatUserCanNotRegisterWithInvalidEmail() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Janet");
        registerUserRequest.setEmail("Janetgmail.com");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("09087654321");
        assertThrows(InvalidEmailException.class, () -> talentUsersService.registerUserResponse(registerUserRequest));
    }

    @Test
    public void testThatUserCanNotRegisterWithInvalidPhoneNumber() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setName("Janet");
        registerUserRequest.setEmail("Janet@gmail.com");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("0908765321");
        assertThrows(InvalidPhoneNumberException.class, () -> talentUsersService.registerUserResponse(registerUserRequest));
    }

    @Test
    public void testThatTalentUserCanLogIn() {
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
    }

    @Test
    public void testThatTalentUserCanLogOut() {
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

        LogOutUserRequest logOutUserRequest = new LogOutUserRequest();
        logOutUserRequest.setEmail("Janet@gmail.com");
        LogOutUserResponse logOutUserResponse = talentUsersService.logOutUserResponse(logOutUserRequest);
        assertThat(logOutUserResponse.getMessage()).isEqualTo("User Logged Out SuccessFully");
    }

    @Test
    public void testThatTalentUserCanPostTalent() {
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
        postTalentRequest.setYearsOfExperience("4");
        PostTalentResponse postTalentResponse = talentUsersService.postTalentResponse(postTalentRequest);
        assertThat(postTalentResponse.getMessage()).isEqualTo("Talents Posted Successfully");
    }
}