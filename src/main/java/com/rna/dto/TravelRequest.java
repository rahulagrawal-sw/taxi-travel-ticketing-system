package com.rna.dto;

public class TravelRequest {

    private String source;
    private String destination;
    private int noOfTravellers;

    public TravelRequest(String source, String destination, int noOfTravellers) {
        this.source = source;
        this.destination = destination;
        this.noOfTravellers = noOfTravellers;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNoOfTravellers() {
        return noOfTravellers;
    }

    public void setNoOfTravellers(int noOfTravellers) {
        this.noOfTravellers = noOfTravellers;
    }
}
