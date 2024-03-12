package com.project.eventos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // JDBC URL, username, and password of Oracle SQL server
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "eventos";
    private static final String PASSWORD = "root";

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to connect to database.");
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
