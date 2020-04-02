package com.rna.util;

import com.rna.dto.TravelRequest;
import com.rna.dto.TravelResponse;

public interface TicketPrintingUtil {

    static boolean printTicket(TravelRequest travelRequest, TravelResponse travelResponse) {
        String newLine = System.lineSeparator();

        String printOutput = "Taxi Travel Ticket"
                + newLine
                + "-----------"
                + newLine
                + "Source: %s"
                + newLine
                + "Destination: %s"
                + newLine
                + "Kms: " + "%.0f"
                + newLine
                + "No. of travellers = %d "
                + newLine
                + "Total = %.0f INR"
                + newLine
                + "-----------";

        System.out.println(String.format(printOutput,
                travelRequest.getSource(),
                travelRequest.getDestination(),
                travelResponse.getDistance(),
                travelRequest.getNoOfTravellers(),
                travelResponse.getFare()
            ));

        return true;
    }
}
