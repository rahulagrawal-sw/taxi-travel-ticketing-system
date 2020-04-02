package com.rna.util;

import com.rna.dto.TravelRequest;
import com.rna.dto.TravelResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketPrintingUtilTest {

    @Test
    @DisplayName("should print ticket, when valid request and calculated fare provided")
    public void testPrintTicket_whenValidFareProvided() {
        TravelRequest travelRequest = new TravelRequest("PUNE", "NASHIK", 2);
        TravelResponse travelResponse = new TravelResponse(200d, 2500d);
        Assertions.assertTrue(TicketPrintingUtil.printTicket(travelRequest, travelResponse));
    }
}
