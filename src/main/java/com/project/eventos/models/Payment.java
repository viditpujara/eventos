package com.project.eventos.models;

public class Payment {
    private int paymentId;
    private int bookingId;
    private double price;
    private String referenceId;
    private String paymentStatus;
    private String paymentMethod;
    public static int counter = 0;

    {
        counter++;
    }

    public Payment() {
        super();
    }

    public Payment(int paymentId, int bookingId, double price, String referenceId, String paymentStatus, String paymentMethod) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.price = price;
        this.referenceId = referenceId;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod; 
        counter++;
   }

    public Payment(int bookingId, double price, String referenceId, String paymentStatus, String paymentMethod) {
        this.paymentId = counter;
        this.bookingId = bookingId;
        this.price = price;
        this.referenceId = referenceId;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod; 
   }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
