package com.kce.parking.model;

public class Vehicle {
    private String regNumber;
    private String type;

    public Vehicle(String regNumber, String type) {
        this.regNumber = regNumber;
        this.type = type;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return "Vehicle [Reg#: " + regNumber + ", Type: " + type + "]";
    }
}
