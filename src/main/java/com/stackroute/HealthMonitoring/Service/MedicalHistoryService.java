package com.stackroute.HealthMonitoring.Service;

import com.stackroute.HealthMonitoring.model.MedicalHistoryData;
import com.stackroute.HealthMonitoring.repo.MedicalHistory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Priyanshu Singh
 */
@Service
public interface MedicalHistoryService {

    // declare a method for storing the Medical History data in the database



    public ResponseEntity<?> saveMedicalHistory(String patientId, MedicalHistoryData medicalHistory);
    public ResponseEntity<?> getMedicalHistory(String patientId);
}
