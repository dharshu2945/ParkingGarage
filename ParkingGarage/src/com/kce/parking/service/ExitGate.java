package com.kce.parking.service;

import com.kce.parking.model.*;

import java.time.LocalDateTime;

public class ExitGate {
    private int gateId;

    public ExitGate(int gateId) {
        this.gateId = gateId;
    }

    public void processExit(Ticket ticket, Tariff tariff) {
        LocalDateTime exitTime = LocalDateTime.now();
        double fee = tariff.calculateFee(ticket.getEntryTime(), exitTime);
        Payment payment = new Payment(ticket.getTicketId(), fee);
        payment.makePayment();
        System.out.println(payment.getReceipt());
        ticket.getSpot().free();
    }
}
