package com.personal.project.services;

import com.personal.project.Exceptions.*;
import com.personal.project.dtos.requests.*;
import com.personal.project.dtos.responses.LogInUserResponse;
import com.personal.project.dtos.responses.LogOutUserResponse;
import com.personal.project.dtos.responses.PostTalentResponse;
import com.personal.project.dtos.responses.RegisterUserResponse;
import com.personal.project.models.TalentUsers;
import com.personal.project.repositories.TalentUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TalentUsersServiceImpl implements TalentUsersService {
    @Autowired
    private TalentUsersRepo talentUsersRepo;

    @Override
    public RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest) {
        validateUser(registerUserRequest.getEmail());
        validateEmail(registerUserRequest.getEmail());
        validatePhoneNumber(registerUserRequest.getPhoneNumber());
        validatePhoneNumberIsNotTheSame(registerUserRequest.getPhoneNumber());
        TalentUsers talentUsers1 = new TalentUsers();
        talentUsers1.setName(registerUserRequest.getName());
        talentUsers1.setEmail(registerUserRequest.getEmail());
        talentUsers1.setPassword(registerUserRequest.getPassword());
        talentUsers1.setPhoneNumber(registerUserRequest.getPhoneNumber());
        talentUsersRepo.save(talentUsers1);
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(talentUsers1.getId());
        registerUserResponse.setMessage("Successfully registered user");
        return registerUserResponse;
    }

    private void validatePhoneNumberIsNotTheSame(String phoneNumber) {
        Optional<TalentUsers> users = talentUsersRepo.findTalentUserByPhoneNumber(phoneNumber);
        if (users.isPresent()) {
            throw new UserAlreadyExistException("User already exists");
        }
    }

    private void validateUser(String email) {
        Optional<TalentUsers> user = talentUsersRepo.findUserByEmail(email);
        if (user.isPresent()) {
            throw new UserAlreadyExistException("User already exists");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 11){
            throw new InvalidPhoneNumberException("Invalid PhoneNumber");
        }
    }

    private void validateEmail(String email) {
        int count = 0;
        for(int counter = 0; counter < email.length(); counter++){
            if(email.charAt(counter) == '@'){
                count++;
            }
        }
        if(count != 1){
            throw new InvalidEmailException("Invalid Email");
        }
    }

    @Override
    public LogInUserResponse logInUserResponse(LogInUserRequest logInUserRequest) {
        TalentUsers talentUsers = talentUsersRepo.findUserByEmail(logInUserRequest.getEmail())
                .orElseThrow(() -> new InvalidEmailException("User not found"));
        validatePassword(logInUserRequest.getPassword());
        LogInUserResponse logInUserResponse = new LogInUserResponse();
        logInUserResponse.setLogin(true);
        logInUserResponse.setId(talentUsers.getId());
        logInUserResponse.setMessage("Logged In Successfully");
        return logInUserResponse;
    }

    private void validatePassword(String password) {
        if(talentUsersRepo.findUserByPassword(password).equals(password)){
            throw new CorrectPasswordException("Correct Password");
        }
    }
    @Override
    public LogOutUserResponse logOutUserResponse(LogOutUserRequest logOutUserRequest) {
        TalentUsers talentUsers = talentUsersRepo.findUserByEmail(logOutUserRequest.getEmail())
                .orElseThrow(() -> new InvalidEmailException("User not found"));
        talentUsers.setLogin(true);
        LogOutUserResponse logOutUserResponse = new LogOutUserResponse();
        logOutUserResponse.setLogin(false);
        logOutUserResponse.setMessage("User Logged Out SuccessFully");
        return logOutUserResponse;
    }

    @Override
    public PostTalentResponse postTalentResponse(PostTalentRequest postTalentRequest) {
        TalentUsers talentUsers = talentUsersRepo.findUserByEmail(postTalentRequest.getEmail())
                .orElseThrow(() -> new InvalidEmailException("User not found"));
        talentUsers.setLogin(true);
        talentUsers.setYearsOfExperience(postTalentRequest.getYearsOfExperience());
        talentUsers.setTalents(postTalentRequest.getTalents());
        talentUsersRepo.save(talentUsers);
        PostTalentResponse postTalentResponse = new PostTalentResponse();
        postTalentResponse.setId(talentUsers.getId());
        postTalentResponse.setMessage("Talents Posted Successfully");
        return postTalentResponse;
    }
}
