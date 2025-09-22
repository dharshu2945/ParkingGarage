package com.kce.parking.service;

import com.kce.parking.model.*;
import java.util.*;

public class ParkingLot {
    private String name;
    private List<ParkingSpot> spots;
    private Map<Integer, Ticket> activeTickets;
    private int ticketCounter = 1;

    public ParkingLot(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
        this.activeTickets = new HashMap<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot findAvailableSpot(String type) {
        for (ParkingSpot spot : spots) {
            if (spot.getType().equalsIgnoreCase(type) && spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    public Ticket issueTicket(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot == null) {
            System.out.println("No available spot for type: " + vehicle.getType());
            return null;
        }
        spot.occupy();
        Ticket ticket = new Ticket(ticketCounter++, vehicle, spot);
        activeTickets.put(ticket.getTicketId(), ticket);
        System.out.println("Ticket issued: " + ticket.getDetails());
        return ticket;
    }

    public void displayOccupancy() {
        for (ParkingSpot spot : spots) {
            System.out.println("Spot#" + spot.getSpotId() + " [" + spot.getType() + "] - " + (spot.isAvailable() ? "Available" : "Occupied"));
        }
    }

    public Ticket getTicket(int ticketId) throws com.kce.parking.exception.InvalidTicketException {
        if (!activeTickets.containsKey(ticketId)) {
            throw new com.kce.parking.exception.InvalidTicketException("Ticket ID not found.");
        }
        return activeTickets.get(ticketId);
    }

    public void removeTicket(int ticketId) {
        activeTickets.remove(ticketId);
    }
}
