package com.personal.project.services;

import com.personal.project.dtos.requests.*;
import com.personal.project.dtos.responses.LogOutUserResponse;
import com.personal.project.dtos.responses.PostTalentResponse;
import com.personal.project.dtos.responses.RegisterUserResponse;
import com.personal.project.dtos.responses.LogInUserResponse;

public interface TalentUsersService {
    RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest);
    LogInUserResponse logInUserResponse(LogInUserRequest logInUserRequest);
    LogOutUserResponse logOutUserResponse(LogOutUserRequest logOutUserRequest);
    PostTalentResponse postTalentResponse(PostTalentRequest postTalentRequest);
}
