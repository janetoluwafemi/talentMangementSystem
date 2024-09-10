package com.personal.project.services;

import com.personal.project.Exceptions.UserHasNotBeenSelected;
import com.personal.project.dtos.requests.SelectingTalentsUserForEmploymentRequest;
import com.personal.project.dtos.responses.SelectingTalentsUserForEmploymentResponse;
import com.personal.project.models.Management;
import com.personal.project.models.TalentUsers;
import com.personal.project.repositories.ManagementRepo;
import com.personal.project.repositories.TalentUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementServiceImpl implements ManagementService{
    @Autowired
    private ManagementRepo managementRepo;
    @Autowired
    private TalentUsersRepo talentUsersRepo;
    @Autowired
    private TalentUsersService talentUsersService;

    @Override
    public SelectingTalentsUserForEmploymentResponse selectingTalentsUserForEmploymentResponse(SelectingTalentsUserForEmploymentRequest selectingTalentsUserForEmploymentRequest) {
        Management management = new Management();
        TalentUsers talentUsers = new TalentUsers();
        SelectingTalentsUserForEmploymentRequest postTalentRequest = new SelectingTalentsUserForEmploymentRequest();
        talentUsers.setYearsOfExperience(selectingTalentsUserForEmploymentRequest.getYearsOfExperience());
        SelectingTalentsUserForEmploymentResponse response = new SelectingTalentsUserForEmploymentResponse();
        if(talentUsers.getYearsOfExperience().equals("5")){
            if(talentUsers.getYearsOfExperience().equals(postTalentRequest.getYearsOfExperience())){
                managementRepo.save(management);
                response.setMessage("User Picked Successfully");
            }
            return response;
        }
        else {
            throw new UserHasNotBeenSelected("User has Not Been Selected");
        }
    }
}
