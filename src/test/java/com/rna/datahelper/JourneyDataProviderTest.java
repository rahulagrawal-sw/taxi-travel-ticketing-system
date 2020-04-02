package com.rna.datahelper;

import com.rna.exception.TravelTicketingSystemServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JourneyDataProviderTest {

    @Test
    @DisplayName("Should return distance, when valid source and destination location is provided")
    public void testCorrectDistance_whenValidLocationsProvided() {
        JourneyDataProvider journeyDataProvider = new JourneyDataProvider();
        double distance = journeyDataProvider.getDistance("PUNE", "NASHIK");
        Assertions.assertEquals(200d, distance);
    }

    @Test
    @DisplayName("Should return distance, when valid source and destination location is provided for return journey")
    public void testCorrectDistance_whenValidLocationsProvidedForReturnJourney() {
        JourneyDataProvider journeyDataProvider = new JourneyDataProvider();
        double distance = journeyDataProvider.getDistance("NASHIK", "PUNE");
        Assertions.assertEquals(200d, distance);
    }

    @Test
    @DisplayName("Should return distance, when some other valid source and destination location is provided")
    public void testCorrectDistance_whenSomeOtherValidLocationsProvided() {
        JourneyDataProvider journeyDataProvider = new JourneyDataProvider();
        double distance = journeyDataProvider.getDistance("PUNE", "MUMBAI");
        Assertions.assertEquals(120d, distance);
    }

    @Test
    @DisplayName("Should throw exception, when invalid source and destination location is provided")
    public void testNoDistanceAvailable_whenInvalidLocationsProvided() {
        JourneyDataProvider journeyDataProvider = new JourneyDataProvider();
        Assertions.assertThrows(TravelTicketingSystemServiceException.class,
                () -> journeyDataProvider.getDistance("PUNE", "ABCD"));

    }
}
