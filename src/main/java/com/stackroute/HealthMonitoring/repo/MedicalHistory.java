package com.stackroute.HealthMonitoring.repo;

import com.stackroute.HealthMonitoring.model.PatientMedicalHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Priyanshu Singh
 */

public interface MedicalHistory extends MongoRepository<PatientMedicalHistory, String> {

 List<MedicalHistory> findByPatientId(String patientId);
}
