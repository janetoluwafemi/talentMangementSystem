package com.personal.project.repositories;

import com.personal.project.models.Management;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepo extends MongoRepository<Management, String> {
}
