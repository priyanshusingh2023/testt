package com.stackroute.HealthMonitoring.Controller;
import com.stackroute.HealthMonitoring.Service.JwtToken;
import com.stackroute.HealthMonitoring.model.LoginRequest;
import com.stackroute.HealthMonitoring.model.Role;
import com.stackroute.HealthMonitoring.model.User;
import com.stackroute.HealthMonitoring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Priyanshu Singh
 */
@RestController
@RequestMapping("/Auth")
@CrossOrigin("*")
public class AuthController {
 @Autowired
    private UserRepo userRepo;

 @Autowired
    private JwtToken JwtToken;

 @PostMapping("register/doctor")
 public ResponseEntity<?> registerUser(@RequestBody User user){
  user.setRole(Role.DOCTOR);
    return ResponseEntity.ok(userRepo.save(user));
 }

    @PostMapping("register/patient")
      public ResponseEntity<?> registerPatient(@RequestBody User user){
            user.setRole(Role.PATIENT);
            return ResponseEntity.ok(userRepo.save(user));
        }


//        login api for both doctor and patient

        @PostMapping("login")
           public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
            System.out.println(loginRequest.getEmail());


//  check if user exits or not
         User user = userRepo.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
         if (user == null) {
          return ResponseEntity.badRequest().body("User not found");
         } else {
          // else generate JWT token and return it with user details
          String jwtToken = JwtToken.generateToken(user.getEmail());
          // return jwt token and user details
          Map<String, Object> map = new HashMap<>();
          map.put("token", jwtToken);
          map.put("user", user);
          return ResponseEntity.ok(map);
         }
        }
}
