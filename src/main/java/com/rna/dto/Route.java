package com.rna.dto;

import java.util.Objects;

public class Route {

    private String place1;
    private String place2;
    private double distance;

    public Route(String place1, String place2, double distance) {
        this.place1 = place1;
        this.place2 = place2;
        this.distance = distance;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Double.compare(route.distance, distance) == 0 &&
                place1.equals(route.place1) &&
                place2.equals(route.place2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place1, place2, distance);
    }
}
