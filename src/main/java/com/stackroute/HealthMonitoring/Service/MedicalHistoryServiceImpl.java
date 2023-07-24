package com.stackroute.HealthMonitoring.Service;

import com.stackroute.HealthMonitoring.model.MedicalHistoryData;
import com.stackroute.HealthMonitoring.model.PatientMedicalHistory;
import com.stackroute.HealthMonitoring.repo.MedicalHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Priyanshu Singh
 */
@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService{

// Autowire the MedicalHistoryRepo
 @Autowired
    MedicalHistory medicalHistoryRepo;
 @Override
 public ResponseEntity<?> saveMedicalHistory(String patientId, MedicalHistoryData medicalHistory) {
  // check if MedicalHistory already exists in the database for given patientId

  Optional<PatientMedicalHistory> medicalHistoryOptional = medicalHistoryRepo.findById(patientId);
    if(medicalHistoryOptional.isPresent()){
        PatientMedicalHistory patientMedicalHistory = medicalHistoryOptional.get();
patientMedicalHistory.getMedicalHistoryDataList().add(medicalHistory);
     return ResponseEntity.ok(medicalHistoryRepo.save(patientMedicalHistory));
    }
    else{
        PatientMedicalHistory patientMedicalHistory = new PatientMedicalHistory();
        patientMedicalHistory.setPatientId(patientId);
        List<MedicalHistoryData> medicalHistoryDataList = new ArrayList<>();
        medicalHistoryDataList.add(medicalHistory);
        patientMedicalHistory.setMedicalHistoryDataList(medicalHistoryDataList);
        medicalHistoryRepo.save(patientMedicalHistory);
        return ResponseEntity.ok(patientMedicalHistory);
    }


 }

 @Override
 public ResponseEntity<?> getMedicalHistory(String patientId) {
     // check if MedicalHistory already exists in the database for given patientId and return the MedicalHistory
     Optional<PatientMedicalHistory> medicalHistoryOptional = medicalHistoryRepo.findById(patientId);
     if (medicalHistoryOptional.isPresent()) {
         PatientMedicalHistory patientMedicalHistory = medicalHistoryOptional.get();
         return ResponseEntity.ok(patientMedicalHistory.getMedicalHistoryDataList());
     } else {
         return ResponseEntity.noContent().build();
     }
 }
}
