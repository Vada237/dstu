package org.example.managers;

import org.example.migrations.*;
import org.example.migrations.interfaces.IMigration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MigrationManager {
    private final List<IMigration> migrations;

    public MigrationManager() {
        this.migrations = new ArrayList<>();
        this.migrations.add(new CreateUserMigration());
        this.migrations.add(new CreateProjectMigration());
        this.migrations.add(new CreateTasksMigration());
        this.migrations.add(new CreateUserTaskMigration());
        this.migrations.add(new AddCurrentUserFieldInTaskTableMigration());
        this.migrations.add(new AddTotalProgressFieldInTasksTableMigration());
        this.migrations.add(new AddStartAndEndTimeInProjectTableMigration());
        this.migrations.add(new AddCountHoursFieldInProjectTableMigration());
    }

    public void runMigrations() throws SQLException {
        for (IMigration migration: this.migrations) {
            migration.up();
        }
    }

    public void dropMigrations() throws SQLException {
        for (int i = this.migrations.size() - 1; i >= 0; i--) {
            this.migrations.get(i).down();
        }
    }
}
