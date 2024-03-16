package com.project.eventos.models;

import java.sql.Timestamp;

public class Booking {
    private int bookingId;
    private int customerId;
    private int eventId;
    private int ticketId;
    private Timestamp bookingTimestamp;
    private int bookingQuantity;
    private double bookingPrice;
    public static int counter = 0;

    {
        counter++;
    }

    public Booking(int bookingId, int customerId, int eventId, int ticketId, Timestamp bookingTimestamp, int bookingQuantity, double bookingPrice) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.eventId = eventId;
        this.ticketId = ticketId;
        this.bookingTimestamp = bookingTimestamp;
        this.bookingQuantity = bookingQuantity;
        this.bookingPrice = bookingPrice;
        counter++;
    }

    public Booking(int customerId, int eventId, int ticketId, Timestamp bookingTimestamp, int bookingQuantity, double bookingPrice) {
        this.bookingId = counter;
        this.customerId = customerId;
        this.eventId = eventId;
        this.ticketId = ticketId;
        this.bookingTimestamp = bookingTimestamp;
        this.bookingQuantity = bookingQuantity;
        this.bookingPrice = bookingPrice;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getBookingTimestamp() {
        return bookingTimestamp;
    }

    public void setBookingTimestamp(Timestamp bookingTimestamp) {
        this.bookingTimestamp = bookingTimestamp;
    }

    public int getBookingQuantity() {
        return bookingQuantity;
    }

    public void setBookingQuantity(int bookingQuantity) {
        this.bookingQuantity = bookingQuantity;
    }

    public double getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(double bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", eventId=" + eventId + ", ticketId="
				+ ticketId + ", bookingTimestamp=" + bookingTimestamp + ", bookingQuantity=" + bookingQuantity
				+ ", bookingPrice=" + bookingPrice + "]";
	}


}
