package org.example.managers;

import org.example.migrations.CreateUserMigration;

import java.sql.SQLException;

public class MigrationManager {
    public void runMigrations() throws SQLException {
        CreateUserMigration createUserMigration = new CreateUserMigration();
        createUserMigration.up();
    }

    public void dropMigrations() throws SQLException {
        CreateUserMigration createUserMigration = new CreateUserMigration();
        createUserMigration.down();
    }
}
