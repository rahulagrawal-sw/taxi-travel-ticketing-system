package com.rna;

import com.rna.dto.TravelRequest;
import com.rna.dto.TravelResponse;
import com.rna.service.TravelFareCalculator;
import com.rna.service.TravelFareCalculatorService;
import com.rna.util.TicketPrintingUtil;

public class TaxiTravelTicketingSystem {

    public static void main(String[] args) {
        TravelFareCalculator travelFareCalculator = new TravelFareCalculatorService();
        TravelRequest travelRequest = new TravelRequest("PUNE", "NASHIK", 1);
        TravelResponse travelResponse = travelFareCalculator.calculateFare(travelRequest);

        TicketPrintingUtil.printTicket(travelRequest, travelResponse);
    }
}
