package com.project.eventos.models;

public class Organizer {
    private int organizerId;
    private String organizerName;
    private String organizerMobile;
    private String organizerEmail;
    public static int counter = 0;

    {
        counter++;
    }

    public Organizer() {
        super();
    }

    public Organizer(int organizerId, String organizerName, String organizerMobile, String organizerEmail) {
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerMobile = organizerMobile;
        this.organizerEmail = organizerEmail;
        counter++;
    }

    public Organizer(String organizerName, String organizerMobile, String organizerEmail) {
        this.organizerId = counter;
        this.organizerName = organizerName;
        this.organizerMobile = organizerMobile;
        this.organizerEmail = organizerEmail;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerMobile() {
        return organizerMobile;
    }

    public void setOrganizerMobile(String organizerMobile) {
        this.organizerMobile = organizerMobile;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", organizerName=" + organizerName + ", organizerMobile="
				+ organizerMobile + ", organizerEmail=" + organizerEmail + "]";
	}
    
}
