package com.kce.parking.model;

public class Payment {
    private int paymentId;
    private double amount;
    private boolean isPaid;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.isPaid = false;
    }

    public void makePayment() {
        isPaid = true;
        System.out.println("Payment of ₹" + amount + " completed.");
    }

    public String getReceipt() {
        return "Receipt#" + paymentId + " | Amount: ₹" + amount + " | Status: " + (isPaid ? "Paid" : "Pending");
    }

    public boolean isPaid() {
        return isPaid;
    }
}
