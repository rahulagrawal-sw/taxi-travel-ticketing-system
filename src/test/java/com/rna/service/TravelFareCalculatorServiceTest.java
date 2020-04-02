package com.rna.service;

import com.rna.dto.TravelRequest;
import com.rna.exception.TravelTicketingSystemServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TravelFareCalculatorServiceTest {

    @Test
    @DisplayName("should return correct calculated fare, when valid travel request is provided")
    public void testCorrectFare_whenValidTravelRequestProvided() {
        TravelFareCalculator travelFareCalculator = new TravelFareCalculatorService();
        TravelRequest travelRequest = new TravelRequest("PUNE", "NASHIK", 1);
        double fare = travelFareCalculator.calculateFare(travelRequest);
        Assertions.assertEquals(1250d, fare);
    }

    @Test
    @DisplayName("should return correct calculated fare, when valid return journey travel request is provided")
    public void testCorrectFare_whenValidTravelRequestProvidedInReturnJounery() {
        TravelFareCalculator travelFareCalculator = new TravelFareCalculatorService();
        TravelRequest travelRequest = new TravelRequest("NASHIK", "PUNE", 1);
        double fare = travelFareCalculator.calculateFare(travelRequest);
        Assertions.assertEquals(1250d, fare);
    }

    @Test
    @DisplayName("should return correct calculated fare, when valid travel request is provided with multiple travellers")
    public void testCorrectFare_whenValidTravelRequestProvidedWithMultipleTravellers() {
        TravelFareCalculator travelFareCalculator = new TravelFareCalculatorService();
        TravelRequest travelRequest = new TravelRequest("PUNE", "NASHIK", 2);
        double fare = travelFareCalculator.calculateFare(travelRequest);
        Assertions.assertEquals(2500d, fare);
    }

    @Test
    @DisplayName("should throw exception, when invalid travel request is provided")
    public void testFareCalculationServiceException_whenInvalidTravelRequestProvided() {
        TravelFareCalculator travelFareCalculator = new TravelFareCalculatorService();
        TravelRequest travelRequest = new TravelRequest("PUNE", "ABCD", 1);
        Assertions.assertThrows(TravelTicketingSystemServiceException.class,
                () -> travelFareCalculator.calculateFare(travelRequest));
    }

    //TODO: perform TravelRequest input validations, as 0 number of travellers should not be allowed
    /*@Test
    @DisplayName("should throw exception, when invalid number of travellers are provided")
    public void testFareCalculationServiceException_whenInvalidNoOfTravellersRequestProvided() {
        TravelFareCalculator travelFareCalculator = new TravelFareCalculatorService();
        TravelRequest travelRequest = new TravelRequest("PUNE", "NASHIK", 0);
        Assertions.assertThrows(TravelTicketingSystemServiceException.class,
                () -> travelFareCalculator.calculateFare(travelRequest));
    }*/
}
