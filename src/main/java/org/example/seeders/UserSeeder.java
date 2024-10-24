package org.example.seeders;

import org.example.models.User;

import java.sql.SQLException;
import java.util.Map;

public class UserSeeder{
    public static void run() throws SQLException {
        User.insert(Map.ofEntries(Map.entry("first_name", "Denis"), Map.entry("second_name", "Le")));
        User.insert(Map.ofEntries(Map.entry("first_name", "Ivan"), Map.entry("second_name", "Ivanov")));
        User.insert(Map.ofEntries(Map.entry("first_name", "Alexander"), Map.entry("second_name", "Petrov")));
        User.insert(Map.ofEntries(Map.entry("first_name", "Smetan"), Map.entry("second_name", "Dubov")));
    }
}
