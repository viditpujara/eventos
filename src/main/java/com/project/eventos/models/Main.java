package com.project.eventos.models;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    // JDBC URL, username, and password of Oracle server
    static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust as per your Oracle instance
    static final String DB_USER = "Eventos";
    static final String DB_PASSWORD = "root";
    

 // Place this method in your Main class
    public static void clearScreen() {
        // Clearing the screen by printing some empty lines
        for (int i = 0; i < 50; ++i) System.out.println();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean Status = true;

        while (Status == true) {
            System.out.println("Welcome to the Event Management System!");
            System.out.println("1. Login as User");
            System.out.println("2. Login as Organizer");
            System.out.println("3. Register as User");
            System.out.println("4. Register as Organizer");
            System.out.println("5. Exit System");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            	
                if (choice == 1) {
                    // User Login
                    System.out.print("Enter username: ");
                    String username = scanner.next();

                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    // Check user credentials
                    if (validateUser(conn, username, password)) {
                        System.out.println("Welcome to Eventos " + username);
                        System.out.println("Select Any Event of Your Choice:  ");

                        // Add further user functionalities like booking events
                        String eventQuery = "SELECT * FROM tbl_events";
                        try (PreparedStatement eventStmt = conn.prepareStatement(eventQuery);
                             ResultSet eventRs = eventStmt.executeQuery()) {
                        
                            while (eventRs.next()) {
                                System.out.println("Event Id: " + eventRs.getInt("event_id") +
                                        "|| Name: " + eventRs.getString("event_name") +
                                        "|| Venue: " + eventRs.getString("event_venue") +
                                        "|| City: " + eventRs.getString("event_city") +
                                        "|| Date: " + eventRs.getString("event_date_time") +
                                        "|| Description: " + eventRs.getString("event_description")+
                                        "|| OrganizerId: " + eventRs.getString("organizer_id"));

                            }
                            System.out.println("Enter Your choice: ");
                            int choiceId = scanner.nextInt();
                            scanner.nextLine();
                            
                            String ticketQuery = "SELECT * FROM tbl_ticket_types WHERE event_id = ?";
                            try (PreparedStatement ticketStmt = conn.prepareStatement(ticketQuery)) {
                                ticketStmt.setInt(1, choiceId);
                                ResultSet ticketRs = ticketStmt.executeQuery();

                                System.out.println("Available Ticket Types for Event " + choiceId + ": ");
                                while (ticketRs.next()) {
                                    System.out.println("Ticket Type: " + ticketRs.getString("ticket_type") +
                                            ", Price: " + ticketRs.getDouble("ticket_price") +
                                            ", Quantity Available: " + ticketRs.getInt("ticket_quantity"));
                                }

                                
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            
                            System.out.println("Enter Which Type Of Ticket You Want: ");
                            String tickChoice = scanner.nextLine();
                            System.out.println("How much Tickets do you want: ");
                            int tickQuant = scanner.nextInt();
                            
                            String checkTicketQuery = "SELECT * FROM tbl_ticket_types WHERE event_id = ? AND ticket_type = ?";
                            try (PreparedStatement checkTicketStmt = conn.prepareStatement(checkTicketQuery)) {
                                checkTicketStmt.setInt(1, choiceId);
                                checkTicketStmt.setString(2, tickChoice);
                                ResultSet checkTicketRs = checkTicketStmt.executeQuery();

                                if (checkTicketRs.next()) {
                                    double ticketPrice = checkTicketRs.getDouble("ticket_price");
//                                    int ticketQuantity = checkTicketRs.getInt("ticket_quantity");

                                    System.out.println("You Need To Pay Rs."+(int)(ticketPrice)*(tickQuant)+" to Buy the "+tickChoice+" ticket");

                                    // Add further logic for payment process or any other action based on the user's choice
                                    // For example, you can prompt the user to proceed with payment or perform any other action

                                }
                                else {
                                    System.out.println("Invalid ticket type. Please select from the available options.");
                                    // Add logic to handle if the entered ticket type is not found
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            
                            System.out.println("Please Select Any Payment Method: ");
                            System.out.println("1. UPI");
                            System.out.println("2. DEBIT CARD");
                            System.out.println("3. CREDIT CARD");
                            System.out.println("4. BANK TRANSFER");
                            
                            System.out.println("Enter Your Choice");
//                            int pay = scanner.nextInt();
                            
                            System.out.println("Thank You For your Confirmation Here is your "+tickQuant+" Tickets of "+tickChoice);
                              
                            
                        } catch (SQLException e) {
                            e.printStackTrace();
                            }                        
                    } else {
                        System.out.println("Invalid username or password.");
                    }

                } else if (choice == 2) {
                    // Organizer Login
                    System.out.print("Enter username: ");
                    String username = scanner.next();

                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    // Check organizer credentials
                    if (validateOrganizer(conn, username, password)) {
                        System.out.println("Welcome to Eventos " + username);
                        // Add further organizer functionalities like creating events
                        
                        System.out.println("Create a New Event:");

                        // Prompt the organizer to input event details
                        System.out.print("Event Name: ");
                        String eventName = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Venue: ");
                        String eventVenue = scanner.nextLine();
                        System.out.print("City: ");
                        String eventCity = scanner.nextLine();
                        System.out.print("Date and Time (YYYY-MM-DD HH:MM:SS): ");
                        String eventDateTime = scanner.nextLine();
                        System.out.print("Description: ");
                        String eventDescription = scanner.nextLine();

                        // Prepare the SQL INSERT statement
                        String insertEventQuery = "INSERT INTO tbl_events(event_name, event_venue, event_city, event_date_time, event_description) VALUES (?, ?, ?, TIMESTAMP ?, ?)";
                        try (PreparedStatement insertEventStmt = conn.prepareStatement(insertEventQuery)) {
                            insertEventStmt.setString(1, eventName);
                            insertEventStmt.setString(2, eventVenue);
                            insertEventStmt.setString(3, eventCity);
                            insertEventStmt.setString(4,eventDateTime);
                            insertEventStmt.setString(5, eventDescription);

                            // Execute the INSERT statement
                            int rowsAffected = insertEventStmt.executeUpdate();
                            if (rowsAffected > 0) {
                                System.out.println("Event created successfully.");
                            } else {
                                System.out.println("Failed to create event.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println("An error occurred while creating the event.");
                        }
                        
                    } else {
                        System.out.println("Invalid username or password.");
                    }

                } else if (choice == 3) {
                    // User Registration
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    System.out.print("Mobile Number: ");
                    String mob_no = scanner.next();
                    System.out.print("Date of Birth (YYYY-MM-DD): ");
                    String dob = scanner.next();
                    Date cus_dob = Date.valueOf(dob);

                    // Register the user
                    Customers cus1 = new Customers();
                    cus1.setCustomerName(username);
                    cus1.setPassword(password);
                    cus1.setCustomerEmail(email);
                    cus1.setCustomerMobileNumber(mob_no);
                    cus1.setCustomerDob(cus_dob);

                    registerUser(conn, cus1.getCustomerName(), cus1.getCustomerEmail(), cus1.getCustomerEmail(), cus1.getCustomerMobileNumber(), cus1.getCustomerDob());
                    clearScreen();

                    System.out.println("User registered successfully.");
                    System.out.println("Now You Can Login To Your Account");

                    

                } else if (choice == 4) {
                    // Organizer Registration

                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter mobile no: ");
                    String mobno = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    // Register the organizer
                    Organizer org = new Organizer();
                    org.setOrganizerName(username);
                    org.setOrganizerPassword(password);
                    org.setOrganizerMobile(mobno);
                    org.setOrganizerEmail(email);

                    registerOrganizer(conn, org.getOrganizerName(), org.getOrganizerMobile(), org.getOrganizerEmail(), org.getOrganizerPassword());
                    clearScreen();
                    System.out.println("Organizer registered successfully.");
                    System.out.println("Now You Can Login To Your Account");

                }
                
                else if(choice==5) {
                	System.out.println("Thanks a Lot For Using our System Visit Again");
                	
                }


            } catch (SQLException e) {
                e.printStackTrace();

            } 
            
            scanner.close();
        }
    }

    // Method to validate user credentials
    static boolean validateUser(Connection conn, String username, String password) throws SQLException {
        String sql = "SELECT * FROM tbl_customers WHERE customer_name = ? AND customer_password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    // Method to validate organizer credentials
    static boolean validateOrganizer(Connection conn, String username, String password) throws SQLException {
        String sql = "SELECT * FROM tbl_organizers WHERE organizer_name = ? AND organizer_password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    // Method to register a new user
    static void registerUser(Connection conn, String username, String password, String email, String mob_no, Date cus_dob) throws SQLException {
        String sql = "INSERT INTO tbl_customers (customer_name, customer_mobile_number, customer_email, customer_dob, customer_password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, mob_no);
            stmt.setString(3, email);
            stmt.setDate(4, cus_dob);
            stmt.setString(5, password);

            stmt.executeUpdate();
        }
    }

    // Method to register a new organizer
    static void registerOrganizer(Connection conn, String username, String mobno, String email, String password) throws SQLException {
        String sql = "INSERT INTO tbl_organizers (organizer_name, organizer_mobile_number, organizer_email, organizer_password) VALUES (?, ?,?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, mobno);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.executeUpdate();
        }
    }
}
