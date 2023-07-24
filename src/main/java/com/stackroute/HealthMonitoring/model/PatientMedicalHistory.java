package com.stackroute.HealthMonitoring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Priyanshu Singh
 */

@Data
@Getter
@Setter
@Document(collection = "patientMedicalHistory")
public class PatientMedicalHistory {
 @Id
 private String patientId;
 private List<MedicalHistoryData> medicalHistoryDataList;

}
