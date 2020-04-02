package com.rna.service;

import com.rna.dto.TravelRequest;
import com.rna.exception.TravelTicketingSystemServiceException;

public interface TravelFareCalculator {

    double calculateFare(TravelRequest travelRequest) throws TravelTicketingSystemServiceException;
}
