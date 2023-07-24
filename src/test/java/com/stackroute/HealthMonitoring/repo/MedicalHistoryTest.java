package com.stackroute.HealthMonitoring.repo;

import com.stackroute.HealthMonitoring.model.PatientMedicalHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.io.FileOutputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Priyanshu Singh
 */
@DataMongoTest
public class MedicalHistoryTest {

    @Autowired
    private MedicalHistory medicalHistoryRepository;


    @Test
    public void testFindByPatientId() {
        // Create a dummy patientId and a PatientMedicalHistory object
        String patientId = "123";
        PatientMedicalHistory medicalHistory = new PatientMedicalHistory();
        medicalHistory.setPatientId(patientId);
        // Save the medical history in the repository
        medicalHistoryRepository.save(medicalHistory);

        // Invoke the findByPatientId method
        List<MedicalHistory> foundMedicalHistories = medicalHistoryRepository.findByPatientId(patientId);

        // Assert that the list is not empty and contains the saved medical history
        assertNotNull(foundMedicalHistories);
        assertEquals(1, foundMedicalHistories.size());
    }


}
