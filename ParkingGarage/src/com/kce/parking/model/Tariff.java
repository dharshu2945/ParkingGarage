package com.kce.parking.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Tariff {
    private double ratePerHour;

    public Tariff(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double calculateFee(LocalDateTime entry, LocalDateTime exit) {
        long hours = Duration.between(entry, exit).toHours();
        return ratePerHour * (hours == 0 ? 1 : hours);
    }
}
