package com.kce.parking.main;

import com.kce.parking.model.*;
import com.kce.parking.service.*;
import com.kce.parking.exception.InvalidTicketException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot("City Garage");
        Tariff tariff = new Tariff(40); // ₹40/hour
        ExitGate gate = new ExitGate(1);

        // Setup sample spots
        lot.addSpot(new ParkingSpot(1, "Car"));
        lot.addSpot(new ParkingSpot(2, "Bike"));
        lot.addSpot(new ParkingSpot(3, "Car"));

        while (true) {
            System.out.println("\n--- Parking Garage Menu ---");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Display Occupancy");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle reg#: ");
                    String reg = sc.next();
                    System.out.print("Enter vehicle type (Car/Bike): ");
                    String type = sc.next();
                    Vehicle v = new Vehicle(reg, type);
                    lot.issueTicket(v);
                    break;

                case 2:
                    System.out.print("Enter ticket ID: ");
                    int id = sc.nextInt();
                    try {
                        Ticket ticket = lot.getTicket(id);
                        gate.processExit(ticket, tariff);
                        lot.removeTicket(id);
                    } catch (InvalidTicketException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    lot.displayOccupancy();
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
