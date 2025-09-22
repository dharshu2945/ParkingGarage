package com.kce.parking.model;

public class ParkingSpot {
    private int spotId;
    private String type;
    private boolean isAvailable;

    public ParkingSpot(int spotId, String type) {
        this.spotId = spotId;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void occupy() {
        isAvailable = false;
    }

    public void free() {
        isAvailable = true;
    }

    public int getSpotId() {
        return spotId;
    }

    public String getType() {
        return type;
    }
}
