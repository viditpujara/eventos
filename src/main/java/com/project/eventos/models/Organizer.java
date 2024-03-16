package com.project.eventos.models;

public class Organizer {
    private int organizerId;
    private String organizerName;
    private String organizerMobile;
    private String organizerEmail;
    private String organizerPassword;
    public static int counter = 0;

    {
        counter++;
    }

    public Organizer() {
        super();
    }

    public Organizer(int organizerId, String organizerName, String organizerMobile, String organizerEmail, String organizerPassword) {
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerMobile = organizerMobile;
        this.organizerEmail = organizerEmail;
        this.organizerPassword = organizerPassword;
        counter++;
    }

    public Organizer(String organizerName, String organizerMobile, String organizerEmail, String organizerPassword) {
        this.organizerId = counter;
        this.organizerName = organizerName;
        this.organizerMobile = organizerMobile;
        this.organizerEmail = organizerEmail;
        this.organizerPassword = organizerPassword;
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



	public String getOrganizerPassword() {
		return organizerPassword;
	}

	public void setOrganizerPassword(String organizerPassword) {
		this.organizerPassword = organizerPassword;
	}

	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", organizerName=" + organizerName + ", organizerMobile="
				+ organizerMobile + ", organizerEmail=" + organizerEmail + "]";
	}

}
