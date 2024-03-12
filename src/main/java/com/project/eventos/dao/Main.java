package com.project.eventos.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Get a connection from the OracleDatabaseConnector class
            connection = DatabaseConnector.getConnection();

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            resultSet = statement.executeQuery("SELECT * FROM demo");

            // Process the result set
            while (resultSet.next()) {
                // Example: String value = resultSet.getString("column_name");
            	System.out.println(resultSet.getString("nothing"));
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseConnector.closeConnection(connection);
        }
    }
}
