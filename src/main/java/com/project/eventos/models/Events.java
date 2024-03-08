package com.project.eventos.models;

import java.sql.Date;

public class Events {
    private int eventId;
    private String eventName;
    private String eventVenue;
    private String eventCity;
    private Date eventDateTime;
    private String eventDescription;
    private int organizerId;
    public static int counter = 0;
    
    
    {
        counter++;
    }
    

    public Events() {
        super();
    }


    public Events(int eventId, String eventName, String eventVenue, String eventCity, Date eventDateTime, String eventDescription, int organizerId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventCity = eventCity;
        this.eventDateTime = eventDateTime;
        this.eventDescription = eventDescription;
        this.organizerId = organizerId;
        counter++;
    }
    
    public Events(String eventName, String eventVenue, String eventCity, Date eventDateTime, String eventDescription, int organizerId) {
        this.eventId = counter;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventCity = eventCity;
        this.eventDateTime = eventDateTime;
        this.eventDescription = eventDescription;
        this.organizerId = organizerId;
    }

    // Getter and Setter methods for each attribute
    
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    
}
