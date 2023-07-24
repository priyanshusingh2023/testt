package com.stackroute.HealthMonitoring.Service;

import com.stackroute.HealthMonitoring.model.Vital;
import com.stackroute.HealthMonitoring.model.VitalRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Priyanshu Singh
 */
@Service
public interface VitalService {

// declare a method for storing the vital data in the database

 public ResponseEntity<?> saveVital(VitalRequest vitalRequest);

    public ResponseEntity<?> getVital(String patientId);
}
