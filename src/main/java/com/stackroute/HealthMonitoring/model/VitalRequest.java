package com.stackroute.HealthMonitoring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Priyanshu Singh
 */
@Data
@Setter
@Getter

public class VitalRequest {
    private String bloodPressure;
    private int heartRate;
    private double temperature;
    private String patientId;

}
