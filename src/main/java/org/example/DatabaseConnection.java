package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/riskMonitoring?serverTimezone=UTC";
        private static final String USER = "root";
        private static final String PASSWORD = "Passw0rd";
        private static Connection connection;
        private static PreparedStatement stmt;
        // Method to get a connection to the database
        public static Connection getConnection() throws SQLException {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        }
    }
