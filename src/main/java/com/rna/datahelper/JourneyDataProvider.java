package com.rna.datahelper;

import com.rna.exception.TravelTicketingSystemServiceException;

import java.util.HashMap;
import java.util.Map;

public class JourneyDataProvider {

    private final static Map<String, Double> JOURNEY_DISTANCE_DATA_CACHE = new HashMap<>();

    /**
     * This method returns distance in KM for a given source location and destination location
     *
     * @param source
     * @param destination
     * @return distance
     */
    public double getDistance(String source, String destination) {
        String key = source + ":" + destination;
        if(null != JOURNEY_DISTANCE_DATA_CACHE.get(key)) {
            return JOURNEY_DISTANCE_DATA_CACHE.get(key);
        }

        key = destination + ":" + source;
        if(null != JOURNEY_DISTANCE_DATA_CACHE.get(key)) {
            return JOURNEY_DISTANCE_DATA_CACHE.get(key);
        }

        throw new TravelTicketingSystemServiceException("No such journey locations are available");
    }

    //For now creating dummy data and storing into local cache.
    static {
        JOURNEY_DISTANCE_DATA_CACHE.put("PUNE:MUMBAI", 120d);
        JOURNEY_DISTANCE_DATA_CACHE.put("PUNE:NASHIK", 200d);
        JOURNEY_DISTANCE_DATA_CACHE.put("MUMBAI:GOA", 350d);
        JOURNEY_DISTANCE_DATA_CACHE.put("MUMBAI:NASHIK", 180d);
    }

}
