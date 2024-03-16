package com.project.eventos.models;

/**
 * @author Vidit Pujara
 *
 * This class is used to create TicketType objects
 * TicketType objects are used to store ticket types for an event
 *
 * The class has 5 attributes:
 * 1. ticketId - int
 * 2. eventId - int
 * 3. ticketType - String
 * 4. ticketPrice - double
 * 5. ticketQuantity - int
 *
 * The class has 2 constructors:
 * 1. Parameterized constructor with 5 parameters
 * 	    - ticketId, eventId, ticketType, ticketPrice, ticketQuantity
 * 2. Parameterized constructor with 4 parameters
 *		- eventId, ticketType, ticketPrice, ticketQuantity
 *
 * The class has 5 getter methods:
 * 1. getTicketId
 * 2. getEventId
 * 3. getTicketType
 * 4. getTicketPrice
 * 5. getTicketQuantity
 *
 * The class has 5 setter methods:
 * 1. setTicketId
 * 2. setEventId
 * 3. setTicketType
 * 4. setTicketPrice
 * 5. setTicketQuantity
 *
 * The class has a toString method which returns the string representation of the object
 */

public class TicketType {
    private int ticketId; // Unique ticket id
    private int eventId; // Event id for which the ticket is created
    private String ticketType; // Type of the ticket
    private double ticketPrice; // Price of the ticket
    private int ticketQuantity; // Quantity of the ticket


	public TicketType() {
		super();
	}
	/**
	 * @param ticketId: int
	 * @param eventId: int
	 * @param ticketType: String
	 * @param ticketPrice: double
	 * @param ticketQuantity: int
	 */
    public TicketType(int ticketId, int eventId, String ticketType, double ticketPrice, int ticketQuantity) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.ticketQuantity = ticketQuantity;
        counter++;
    }
    /**
     * @param eventId: int
     * @param ticketType: String
     * @param ticketPrice: double
     * @param ticketQuantity: int
     */
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
    /**
     * @return String
     */
	@Override
	public String toString() {
		return "TicketType [ticketId=" + ticketId + ", eventId=" + eventId + ", ticketType=" + ticketType
				+ ", ticketPrice=" + ticketPrice + ", ticketQuantity=" + ticketQuantity + "]";
	}

}
