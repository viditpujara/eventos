package com.project.eventos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vidit Pujara
 * @version 1.0
 * @since 2024-03-13
 *
 * @method getConnection: This method is used to establish a connection to the database.
 * @method closeConnection: This method is used to close the database connection.
 *
 * @see java.sql.Connection
 * @see java.sql.DriverManager
 * @see java.sql.SQLException
 * @see java.sql.Statement
 * @see java.sql.ResultSet
 *
 * This class is used to establish a connection to the database and close the connection.
 * It uses the JDBC driver to connect to the Oracle SQL server.
 */
public class DatabaseConnector {

    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // URL of the Oracle SQL server
    private static final String USERNAME = "eventos"; // Username of the Oracle SQL server
    private static final String PASSWORD = "root"; // Password of the Oracle SQL server

    /**
     * Method to establish a connection to the database
 	 *
     * @method getConnection
     *
     * @param JDBC_URL: String
     * @param USERNAME: String
     * @param PASSWORD: String
     *
     * @return Connection
     * @throws SQLException
     */
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
    /**
     * Method to close the database connection
     *
     * @method closeConnection
     * @param connection: Connection
     * @throws SQLException
     */
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
