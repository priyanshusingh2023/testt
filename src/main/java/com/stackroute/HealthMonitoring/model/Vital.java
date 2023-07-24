package com.stackroute.HealthMonitoring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author Priyanshu Singh
 */

@Data
@Getter
@Setter


@Document(collection = "vital")

public class Vital {
  @Id
  private String id = UUID.randomUUID().toString();
  private String bloodPressure;
  private int heartRate;
  private double temperature;
  private String patientId;
  private String timeStamp;
}
