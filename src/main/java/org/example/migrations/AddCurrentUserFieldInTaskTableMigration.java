package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Task;
import org.example.models.User;

import java.sql.SQLException;

public class AddCurrentUserFieldInTaskTableMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate(
                "ALTER TABLE " + Task.tableName + " ADD COLUMN current_user_id INT REFERENCES " +
                        User.tableName + "(id)"
        );
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("ALTER TABLE " + Task.tableName + " DROP COLUMN current_user_id");
    }
}
