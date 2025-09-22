package com.kce.parking.model;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public Ticket(int ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String getDetails() {
        return "Ticket#" + ticketId + " | " + vehicle.getDetails() + " | Spot#" + spot.getSpotId();
    }
}
