package com.stackroute.HealthMonitoring.Controller;

import com.stackroute.HealthMonitoring.Service.VitalService;
import com.stackroute.HealthMonitoring.model.VitalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Priyanshu Singh
 */
@RestController
@RequestMapping("/vital")
@CrossOrigin("*")

public class VitalController {

// Auto wire the VitalService interface

 @Autowired
 private VitalService vitalService;

// Create a rest API for storing the vital data in the database using the post method

 @PostMapping("/saveVital")
 public ResponseEntity<?> saveVital(@RequestBody VitalRequest vitalRequest) {

// call the saveVital method of the VitalService interface
  return vitalService.saveVital(vitalRequest);


 }

 // Create a rest API for getting the vital data for a Patient the database using the get method
 @GetMapping("/getVital/{patientId}")
 public ResponseEntity<?> getVital(@PathVariable String patientId) {

// call the getVital method of the VitalService interface
  return vitalService.getVital(patientId);

 }
}
