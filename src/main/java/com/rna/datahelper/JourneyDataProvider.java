package com.rna.datahelper;

import com.rna.dto.Route;
import com.rna.exception.TravelTicketingSystemServiceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JourneyDataProvider {

    private final static Map<String, List<Route>> JOURNEY_DISTANCE_DATA_CACHE = new HashMap<>();

    /**
     * This method returns distance in KM for a given source location and destination location
     *
     * @param source
     * @param destination
     * @return distance
     */
    public double getDistance(String source, String destination) {
        String key = source + ":" + destination;
        List<Route> routes = null;
        if(null != JOURNEY_DISTANCE_DATA_CACHE.get(key)) {
             routes = JOURNEY_DISTANCE_DATA_CACHE.get(key);
        }

        key = destination + ":" + source;
        if(routes == null || routes.size() <= 0) {
            routes = JOURNEY_DISTANCE_DATA_CACHE.get(key);
        }

        //sum up distances of multiple route for a given journey
        if(routes != null && routes.size() > 0) {
            return routes.stream().collect(Collectors.summingDouble(Route::getDistance));
        }

        throw new TravelTicketingSystemServiceException("No such journey locations are available");
    }

    //For now creating dummy data and storing into local cache.
    static {
        List<Route> routesPuneNashik = new ArrayList<>();
        routesPuneNashik.add(new Route("PUNE", "NAGAR", 120d));
        routesPuneNashik.add(new Route("NAGAR", "NASHIK", 80d));
        JOURNEY_DISTANCE_DATA_CACHE.put("PUNE:NASHIK", routesPuneNashik);

        List<Route> routesPuneMumbai = new ArrayList<>();
        routesPuneMumbai.add(new Route("PUNE", "PANVEL", 40d));
        routesPuneMumbai.add(new Route("PANVEL", "LONAWALA", 60d));
        routesPuneMumbai.add(new Route("LONAWALA", "MUMBAI", 20d));
        JOURNEY_DISTANCE_DATA_CACHE.put("PUNE:MUMBAI", routesPuneMumbai);
    }

}
