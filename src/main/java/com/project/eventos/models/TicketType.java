package com.project.eventos.models;

public class TicketType {
    private int ticketId;
    private int eventId;
    private String ticketType;
    private double ticketPrice;
    private int ticketQuantity;
    public static int counter = 0;

    {
        counter++;
    }

    public TicketType(int ticketId, int eventId, String ticketType, double ticketPrice, int ticketQuantity) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.ticketQuantity = ticketQuantity;
        counter++;
    }

    public TicketType(int eventId, String ticketType, double ticketPrice, int ticketQuantity) {
        this.ticketId = counter;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.ticketQuantity = ticketQuantity;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
     } 
    
}
