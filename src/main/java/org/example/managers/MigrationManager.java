package org.example.managers;

import org.example.migrations.CreateProjectMigration;
import org.example.migrations.CreateTasksMigration;
import org.example.migrations.CreateUserMigration;
import org.example.migrations.CreateUserTaskMigration;

import java.sql.SQLException;

public class MigrationManager {
    public void runMigrations() throws SQLException {
        CreateUserMigration createUserMigration = new CreateUserMigration();
        createUserMigration.up();

        CreateProjectMigration createProjectMigration = new CreateProjectMigration();
        createProjectMigration.up();

        CreateTasksMigration createTasksMigration = new CreateTasksMigration();
        createTasksMigration.up();

        CreateUserTaskMigration createUserTaskMigration = new CreateUserTaskMigration();
        createUserTaskMigration.up();
    }

    public void dropMigrations() throws SQLException {
        CreateUserTaskMigration createUserTaskMigration = new CreateUserTaskMigration();
        createUserTaskMigration.down();

        CreateTasksMigration createTasksMigration = new CreateTasksMigration();
        createTasksMigration.down();

        CreateProjectMigration createProjectMigration = new CreateProjectMigration();
        createProjectMigration.down();

        CreateUserMigration createUserMigration = new CreateUserMigration();
        createUserMigration.down();
    }
}
