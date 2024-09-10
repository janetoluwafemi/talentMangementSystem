package com.personal.project.repositories;

import com.personal.project.models.TalentUsers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TalentUsersRepo extends MongoRepository<TalentUsers, String> {
    Optional<TalentUsers> findUserByEmail(String email);
    Optional<TalentUsers> findTalentUsersById(String id);
    Optional<TalentUsers> findTalentUserByPhoneNumber(String phoneNumber);
    TalentUsers findUserByPassword(String password);
}
