package com.stackroute.HealthMonitoring.repo;

import com.stackroute.HealthMonitoring.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Priyanshu Singh
 */
@Repository
public interface UserRepo extends MongoRepository<User, String> {

 User findByEmailAndPassword(String email, String password);
}
