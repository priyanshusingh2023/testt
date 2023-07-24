package com.stackroute.HealthMonitoring.Service;

import com.stackroute.HealthMonitoring.model.MedicalHistoryData;
import com.stackroute.HealthMonitoring.repo.MedicalHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Priyanshu Singh
 */
@SpringBootTest
public class MedicalHistoryServiceTest {

    @Autowired
    private MedicalHistoryService medicalHistoryService;


    @Test
    public void saveMedicalHistory() {

//        test MedicalHistoryService.saveMedicalHistory()

        String patientId = "1";
        MedicalHistoryData medicalHistoryData = new MedicalHistoryData();
//        medicalHistoryData.setDisease("Cancer");
//        medicalHistoryData.setMedicine("Paracetamol");
//        medicalHistoryData.setSymptoms("Fever");
//        medicalHistoryData.setTreatment("Chemotherapy");
//        medicalHistoryData.setDoctorName("Dr. Priyanshu");
//        medicalHistoryData.setHospitalName("Apollo");
//        medicalHistoryData.setComments("No Comments");
//        medicalHistoryData.setPrescription("No Prescription");
//        medicalHistoryData.setTestResults("No Test Results");
//        medicalHistoryData.setTestName("No Test Name");
//        medicalHistoryData.setTestDate("No Test Date");
//        medicalHistoryData.setTestComments("No Test Comments");
//        medicalHistoryData.setTestDoctorName("No Test Doctor Name");
//        medicalHistoryData.setTestHospitalName("No Test Hospital Name");

        medicalHistoryService.saveMedicalHistory(patientId, medicalHistoryData);

        assert(medicalHistoryService.getMedicalHistory(patientId).getStatusCode().is2xxSuccessful());

    }



}
