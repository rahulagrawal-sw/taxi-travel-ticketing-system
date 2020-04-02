package com.rna.service;

import com.rna.dto.TravelRequest;
import com.rna.dto.TravelResponse;
import com.rna.exception.TravelTicketingSystemServiceException;

public interface TravelFareCalculator {

    TravelResponse calculateFare(TravelRequest travelRequest) throws TravelTicketingSystemServiceException;
}
