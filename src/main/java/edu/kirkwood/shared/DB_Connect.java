package edu.kirkwood.shared;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
    public static Connection getConnection() {
        Dotenv dotenv = Dotenv.load();
        String driver = dotenv.get("DB_DRIVER");
        String connectionString = dotenv.get("DB_CONNECTION");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Could not load JDBC driver");
        }
        try {
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            return connection;
        } catch(SQLException e) {
            throw new RuntimeException("Could not connect to database - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}
