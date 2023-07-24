package com.stackroute.HealthMonitoring.Controller;
import com.stackroute.HealthMonitoring.Service.MedicalHistoryService;
import com.stackroute.HealthMonitoring.model.MedicalHistoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Priyanshu Singh
 */
@RestController
@RequestMapping("/medicalhistory")
@CrossOrigin("*")
public class MedicalHistoryController {

     //autowired the MedicalHistoryService interface
     @Autowired
     private MedicalHistoryService medicalHistoryService;

     // declare a method for storing the Medical History data in the database
     @PostMapping("/save/{pID}")
     public ResponseEntity<?> saveMedicalHistory(@PathVariable("pID") String patientId, @RequestBody MedicalHistoryData medicalHistory){
      return medicalHistoryService.saveMedicalHistory(patientId, medicalHistory);
    }
    // declare a method for fetching the Medical History data from the database
    @GetMapping("/get/{pID}")
    public ResponseEntity<?> getMedicalHistory(@PathVariable("pID") String patientId){
    return medicalHistoryService.getMedicalHistory(patientId);
    }
}


