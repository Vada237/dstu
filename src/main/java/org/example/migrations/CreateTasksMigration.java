package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.Project;
import org.example.models.Task;

import java.sql.SQLException;

public class CreateTasksMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate("CREATE TABLE IF NOT EXISTS " + Task.tableName +
                "(" +
                "id serial primary key, " +
                "title varchar, " +
                "start_time timestamp(0), " +
                "end_time timestamp(0), " +
                "status varchar," +
                "project_id int references " + Project.tableName + "(id)" +
                ")");
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("DROP TABLE IF EXISTS " + Task.tableName);
    }
}
