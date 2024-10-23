package org.example.migrations;

import org.example.managers.PostgresManager;
import org.example.migrations.interfaces.IMigration;
import org.example.models.User;

import java.sql.SQLException;

public class CreateUserMigration implements IMigration {
    @Override
    public void up() throws SQLException {
        PostgresManager.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        User.tableName +
                        " (id serial primary key, first_name varchar, second_name varchar)"
        );
    }

    @Override
    public void down() throws SQLException {
        PostgresManager.executeUpdate("DROP TABLE IF EXISTS " + User.tableName);
    }
}
