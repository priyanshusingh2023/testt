package com.stackroute.HealthMonitoring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author Priyanshu Singh
 */

@Data
@Getter
@Setter

@Document(collection = "user")

public class User {
 @Id
  private String userId = UUID.randomUUID().toString();
     private String name;
     @Indexed(unique = true)
     private String email;
     private String password;
     private Role role;
}
