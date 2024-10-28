package org.example;

import org.example.managers.MigrationManager;
import org.example.seeders.Seeder;

import java.sql.SQLException;

public class DataMain {
    public static void main(String[] args) throws SQLException {
        if (Settings.ENABLE_MIGRATIONS) {
            MigrationManager migrationManager = new MigrationManager();
            migrationManager.dropMigrations();
            migrationManager.runMigrations();
            Seeder.run();
        }
    }
}
