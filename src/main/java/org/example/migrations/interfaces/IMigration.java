package org.example.migrations.interfaces;

import java.sql.SQLException;

public interface IMigration {
    public void up() throws SQLException;
    public void down() throws SQLException;
}
