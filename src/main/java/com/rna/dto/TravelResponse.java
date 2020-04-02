package com.rna.dto;

public class TravelResponse {

    private double distance;
    private double fare;

    public TravelResponse(double distance, double fare) {
        this.distance = distance;
        this.fare = fare;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
