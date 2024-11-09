package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Project;
import org.example.models.Task;

import java.sql.SQLException;

public class AddCountHoursFieldInProjectTableMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate("ALTER TABLE " + Project.tableName + " ADD COLUMN count_hours int DEFAULT 0");
        PostgresManager.executeUpdate("ALTER TABLE " + Task.tableName + " ADD COLUMN count_hours int DEFAULT 0");
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("ALTER TABLE " + Project.tableName + " DROP COLUMN IF EXISTS count_hours");
        PostgresManager.executeUpdate("ALTER TABLE " + Task.tableName + " DROP COLUMN IF EXISTS count_hours");
    }
}
