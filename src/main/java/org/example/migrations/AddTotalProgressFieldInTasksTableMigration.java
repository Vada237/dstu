package org.example.migrations;

import java.sql.SQLException;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Task;
import org.example.models.UserTask;

public class AddTotalProgressFieldInTasksTableMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate("ALTER TABLE " + Task.tableName + " ADD COLUMN IF NOT EXISTS total_progress int DEFAULT 0");
        PostgresManager.executeUpdate("ALTER TABLE " + UserTask.tableName + " ADD COLUMN IF NOT EXISTS total_progress int DEFAULT 0");
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("ALTER TABLE " + Task.tableName + " DROP COLUMN IF EXISTS total_progress");
        PostgresManager.executeUpdate("ALTER TABLE " + UserTask.tableName + " DROP COLUMN IF EXISTS total_progress");
    }
}
