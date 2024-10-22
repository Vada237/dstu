package org.example.managers;

import java.sql.*;

import org.example.Settings;

public class PostgresManager {
    public static Connection conn = PostgresManager.connect();

    public static Connection connect() {
        try {
            return DriverManager.getConnection(Settings.URL, Settings.USER, Settings.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeSelect(String query) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

    public static void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }
}
