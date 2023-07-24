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

@Document(collection = "medicalhistory")
public class MedicalHistoryData {

//  "id": 3,  "timestamp": "2023-06-25T14:00:00Z", "doctorId": 456, "notes": "Patient complained of chest pain.","diagnosis": "Angina", "prescriptions" declare data members:

     @Id
        private String MHid = UUID.randomUUID().toString();
        private String timestamp;
        private String doctorId;
        private String notes;
        private String diagnosis;
        private Prescription prescriptions;
}
