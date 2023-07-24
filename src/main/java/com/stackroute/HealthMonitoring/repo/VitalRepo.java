package com.stackroute.HealthMonitoring.repo;

import com.stackroute.HealthMonitoring.model.Vital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Priyanshu Singh
 */
@Repository
public interface VitalRepo extends MongoRepository<Vital, String> {

 List<Vital> findByPatientId(String patientId);

}