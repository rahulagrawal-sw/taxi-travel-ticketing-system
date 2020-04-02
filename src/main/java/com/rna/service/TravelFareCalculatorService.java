package com.rna.service;

import com.rna.datahelper.JourneyDataProvider;
import com.rna.dto.TravelRequest;
import com.rna.dto.TravelResponse;
import com.rna.exception.TravelTicketingSystemServiceException;

public class TravelFareCalculatorService implements TravelFareCalculator {

    private final static double BASE_FARE = 750d;
    private final static double BASE_KM = 100d;
    private final static double PER_KM_RATE = 5d;


    /**
     * This method performs calculations based on provided Travel Request to calculate fare amount.
     *
     * @param travelRequest
     * @return
     * @throws TravelTicketingSystemServiceException
     */
    @Override
    public TravelResponse calculateFare(TravelRequest travelRequest) throws TravelTicketingSystemServiceException {
        try {
            //1. Get distance for given source and destination locations
            JourneyDataProvider journeyDataProvider = new JourneyDataProvider();
            double distance = journeyDataProvider.getDistance(travelRequest.getSource(), travelRequest.getDestination());

            //2. perform fare calculations
            double fare = BASE_FARE;

            if (distance > BASE_KM) {
                fare += (distance - BASE_KM) * PER_KM_RATE; // fare per traveller
            }

            fare = fare * travelRequest.getNoOfTravellers();

            return new TravelResponse(distance, fare);

        }catch (RuntimeException e) {
            throw new TravelTicketingSystemServiceException("fare calculations is failed");
        }
    }
}
