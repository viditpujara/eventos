package com.project.eventos.models;

import java.sql.Date;

public class Customers {

	private int customerId;
    private String customerName;
    private String customerMobileNumber;
    private String customerEmail;
    private Date customerDob;
    private String password;

    public static int counter = 0;


    {
    	counter++;
    }



    public Customers() {
		super();
	}

	public Customers(int customerId, String customerName, String customerMobileNumber, String customerEmail, Date customerDob,String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerDob = customerDob;
        this.password = password;

        counter++;
    }

    public Customers(String customerName, String customerMobileNumber, String customerEmail, Date customerDob,String password) {
        this.customerId = counter;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerDob = customerDob;
        this.password = password;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCustomerDob() {
        return customerDob;
    }

    public void setCustomerDob(Date customerDob) {
        this.customerDob = customerDob;
    }

	public String getCustomerPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNumber="
				+ customerMobileNumber + ", customerEmail=" + customerEmail + ", customerDob=" + customerDob
				+ ", password=" + password + "]";
	}

}
