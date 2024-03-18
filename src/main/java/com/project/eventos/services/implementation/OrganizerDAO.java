/**
 * 
 * @author: vidit
 */
package com.project.eventos.services.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.eventos.models.Organizer;
import com.project.eventos.services.dao.OrganizerDAOInterface;
import com.project.eventos.utility.DatabaseConnector;
import com.project.eventos.utility.PasswordDecryption;

public class OrganizerDAO implements OrganizerDAOInterface {

	/**
	 * 
	 */
	public OrganizerDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String registerOrganizer(String organizerName, String organizerMobileNumber, String organizerEmail,
			String organizerPasswordHash, String organizerPasswordSalt) {
		
		return null;
	}

	@Override
	public String registerOrganizer(Organizer organizer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginOrganizer(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Organizer getOrganizer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOrganizer(Organizer organizer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyOrganizer(String email, String password) {
		
		String status = "Login Denied! Incorrect Username or Password";
		boolean valid = false;
		
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		
		// Get the organizer from the database
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			System.out.println("Connecting to the database...");
			Connection db = DatabaseConnector.getConnection();
			
			System.out.println("Connected to the database!");
			
			ps = db.prepareStatement("SELECT * FROM tbl_organizers WHERE organizer_email = ?");
			
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
                String passwordHash = rs.getString("organizer_password_hash");
                String passwordSalt = rs.getString("organizer_password_salt");
                
                System.out.println("Password Hash: " + passwordHash);
                System.out.println("Password Salt: " + passwordSalt);
                
                valid = PasswordDecryption.decryption(password,passwordHash, passwordSalt);
                
                if(valid) {
                    status = "Login Successful!";
                }
            }
			db.close();
		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}
		
		System.out.println("Status: " + status);
		return valid;
	}

}
