package com.project.eventos.models;

import org.passay.PasswordData;
import org.passay.PasswordHasher;
import org.passay.PasswordHasherFactory;
import org.passay.PasswordHasherFactory.PasswordHasherBuilder;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class Argon2Encryption {

    private static final int SALT_LENGTH = 19;

    public static void main(String[] args) {
        String password = "mysecretpassword";

        // Generate salt
        byte[] salt = generateSalt();

        // Hash password with Argon2
        PasswordHasher hasher = createArgon2PasswordHasher();
        String hashedPassword = hasher.hashPassword(password.toCharArray(), salt);

        // Print hashed password and salt
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
    }

    // Method to generate salt
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    // Method to create an Argon2 PasswordHasher
    private static PasswordHasher createArgon2PasswordHasher() {
        PasswordHasherFactory factory = new PasswordHasherFactory();
        PasswordHasherBuilder builder = factory.builder();
        return builder.build();
    }
}
