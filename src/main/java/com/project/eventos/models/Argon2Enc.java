package com.project.eventos.models;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import org.bouncycastle.util.encoders.Hex; 

public class Argon2Enc {

    private static final int SALT_LENGTH = 19;
    private static final int HASH_LENGTH = 64; // Adjust as per requirement

    // Method to encrypt the password and return hashed password along with salt
    public static String encrypt(String password) {
        // Generate salt
        byte[] salt = generateSalt();
        Charset
        // Initialize Argon2
        Argon2 argon2 = Argon2Factory.create();

        // Hash password
        String hashedPassword = argon2.hash(HASH_LENGTH, 65536, 1, password.toCharArray(), salt);

        // Encode salt and hashed password
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String encodedHashedPassword = Base64.getEncoder().encodeToString(hashedPassword.getBytes(StandardCharsets.UTF_8));

        return encodedSalt + ":" + encodedHashedPassword;
    }

    // Method to decrypt the password using Argon2
    public static boolean decrypt(String encryptedPassword, String inputPassword) {
        // Split the encrypted password into salt and hashed password
        String[] parts = encryptedPassword.split(":");
        if (parts.length != 2) {
            return false; // Invalid format
        }

        // Decode salt and hashed password
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hashedPassword = Base64.getDecoder().decode(parts[1]);

        // Initialize Argon2
        Argon2 argon2 = Argon2Factory.create();

        // Verify password
        return argon2.verify(hashedPassword, inputPassword.toCharArray(), salt);
    }

    // Method to generate salt
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        
        return salt;
    }

    public static void main(String[] args) {
        String password = "mysecretpassword";

        // Encrypt the password
        String encryptedPassword = encrypt(password);
        System.out.println("Encrypted Password: " + encryptedPassword);

        // Decrypt the password and verify
        String inputPassword = "mysecretpassword";
        boolean isMatch = decrypt(encryptedPassword, inputPassword);
        System.out.println("Password Match: " + isMatch);
    }
}
