//package com.stackroute.HealthMonitoring.Controller;
//
//import com.stackroute.HealthMonitoring.Service.VitalService;
//import com.stackroute.HealthMonitoring.model.VitalRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * @author Priyanshu Singh
// */
//@WebMvcTest(VitalController.class)
//
//public class VitalControllerTest {
//
//
// /**
//  * @author Priyanshu Singh
//  */
//
// @InjectMocks
// private VitalController vitalController;
//
//
// @MockBean
// private VitalService vitalService;
//
//
// @Autowired
// private MockMvc mockMvc;
//
// //    add test case for Vital controller to check if the saveVital method is working properly
//// @Test
//// public void getVitalTest() throws Exception {
////     VitalRequest vitalRequest = new VitalRequest();
////
////     // Mock the behavior of the service
////     when(vitalService.saveVital(vitalRequest)).thenReturn(expectedResponse);
////
////     // Call the method on the controller that you want to test
////     ResponseEntity<?> response = vitalController.saveVital(vitalRequest);
////
////     // Verify the expected behavior
////     assertNotNull(response);
////     assertEquals(expectedResponse, response);
////     assertEquals(HttpStatus.OK, response.getStatusCode());
//// }
//
//  @Test
//  public void saveVitalTest() throws Exception {
//      String pId= "fadf9249-0aca-490a-b6b1-553109f0c6cc";
//   mockMvc.perform(post("/getVital/{patientId}",pId))
//           .andExpect(status().isOk());
//  }
//
//
// }
//
//


package com.stackroute.HealthMonitoring.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.HealthMonitoring.Service.VitalService;
import com.stackroute.HealthMonitoring.model.VitalRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
class VitalControllerTest {

// test cases for testing VitalController

 private MockMvc mockMvc;

 @Mock
 private VitalService vitalService;

 @InjectMocks
 private VitalController vitalController;

 private ObjectMapper objectMapper;

 @BeforeEach
 void setUp() {
  MockitoAnnotations.initMocks(this);
  mockMvc = MockMvcBuilders.standaloneSetup(vitalController).build();
  objectMapper = new ObjectMapper();
 }

 @Test
 void saveVital_ValidVitalRequest_Returns200() throws Exception {
  // Arrange
  VitalRequest vitalRequest = new VitalRequest();
  // Set up the vitalRequest object

  when(vitalService.saveVital(vitalRequest)).thenReturn(ResponseEntity.ok().build());

  // Act & Assert
  mockMvc.perform(MockMvcRequestBuilders.post("/vital/saveVital")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(objectMapper.writeValueAsString(vitalRequest)))
          .andExpect(MockMvcResultMatchers.status().isOk());

  // Verify
  verify(vitalService, times(1)).saveVital(vitalRequest);
 }


}
