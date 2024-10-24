package org.example.models;


import org.example.managers.PostgresManager;

import java.sql.SQLException;
import java.util.Map;

public abstract class Model {
    public static String tableName = "";

    public static void insert(Map<String, Object> params, String tableName) throws SQLException {
        String fields = String.join(", ", params.keySet());
        String[] paramKeys = new String[params.size()];

        for (int i = 0; i < params.size(); i++) {
            paramKeys[i] = "?";
        }

        String paramQueryPart = String.join(", ", paramKeys);
        String query = "INSERT INTO " + tableName + " (" + fields + ") VALUES " + "(" + paramQueryPart + ")";
        PostgresManager.executeUpdate(query, params.values().toArray());
    }
}
