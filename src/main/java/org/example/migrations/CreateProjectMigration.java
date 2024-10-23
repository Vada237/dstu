package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Project;

import java.sql.SQLException;

public class CreateProjectMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate("CREATE TABLE IF NOT EXISTS " + Project.tableName +
                "(id serial primary key, title varchar)");
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("DROP TABLE IF EXISTS " + Project.tableName);
    }
}
