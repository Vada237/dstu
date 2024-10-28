package org.example;

import org.example.managers.MigrationManager;
import org.example.models.Task;
import org.example.seeders.Seeder;

import java.sql.SQLException;
import java.util.List;

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
