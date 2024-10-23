package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Task;
import org.example.models.User;
import org.example.models.UserTask;

import java.sql.SQLException;

public class CreateUserTaskMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " + UserTask.tableName +
                        " (" +
                        "task_id INT REFERENCES " + Task.tableName + "(id), " +
                        "user_id INT REFERENCES " + User.tableName + "(id), " +
                        "tracked_time INT, " +
                        "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                        "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                        ")"
        );
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("DROP TABLE IF EXISTS " + UserTask.tableName);
    }
}
