package com.stackroute.HealthMonitoring.Service;

import com.stackroute.HealthMonitoring.model.User;
import com.stackroute.HealthMonitoring.model.Vital;
import com.stackroute.HealthMonitoring.model.VitalRequest;
import com.stackroute.HealthMonitoring.repo.UserRepo;
import com.stackroute.HealthMonitoring.repo.VitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Priyanshu Singh
 */
@Service
public class VitalServiceImpl implements VitalService {
 @Autowired
 private VitalRepo vitalRepo;
 @Autowired
 private UserRepo userRepo;
 @Override
 public ResponseEntity<?> saveVital(VitalRequest vitalRequest) {
     //   check if patient id exists in the database
//         Optional<User> user = userRepo.findById(vitalRequest.getPatientId());
//         if (user.isPresent()) {
    //   if patient id exists then save the vital data in the database
          Vital vital = new Vital();
          vital.setPatientId(vitalRequest.getPatientId());
          vital.setHeartRate(vitalRequest.getHeartRate());
          vital.setTemperature(vitalRequest.getTemperature());
          vital.setBloodPressure(vitalRequest.getBloodPressure());
          // store current timestamp with date and time
          String timeStamp = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss").format(new Date());
          vital.setTimeStamp(timeStamp);
          return ResponseEntity.ok(vitalRepo.save(vital));
         }

//         else{
//          //   if patient id does not exist then return null
//             return ResponseEntity.badRequest().body("Patient not found");
//         }



 @Override
 public ResponseEntity<?> getVital(String patientId) {
      Map map = new HashMap();
        map.put("patientId", patientId);
      List<Vital> vital = vitalRepo.findByPatientId(patientId);
        map.put("vital", vital);
        return ResponseEntity.ok(map);
 }
}

