package com.stackroute.HealthMonitoring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Priyanshu Singh
 */

@Data
@Getter
@Setter
public class Prescription {


 // "medication": "Nitroglycerin","dosage": "0.4mg", "frequency": "As needed",  "startDate": "2023-06-25", "endDate": null declare data variabless

    private String medication;
    private String dosage;
    private String frequency;
    private String startDate;
    private String endDate;

}
