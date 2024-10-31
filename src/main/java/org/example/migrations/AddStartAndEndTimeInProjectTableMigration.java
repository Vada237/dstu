package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Project;

import java.sql.SQLException;

public class AddStartAndEndTimeInProjectTableMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate(
                "ALTER TABLE " + Project.tableName + " ADD COLUMN IF NOT EXISTS start_time TIMESTAMP(0)"
        );

        PostgresManager.executeUpdate(
                "ALTER TABLE " + Project.tableName + " ADD COLUMN IF NOT EXISTS end_time TIMESTAMP(0)"
        );
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate(
                "ALTER TABLE " + Project.tableName + " DROP COLUMN IF EXISTS start_time"
        );

        PostgresManager.executeUpdate(
                "ALTER TABLE " + Project.tableName + " DROP COLUMN IF EXISTS end_time"
        );
    }
}
