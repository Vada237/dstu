package org.example;

import javax.xml.ws.Endpoint;

import org.example.managers.MigrationManager;
import org.example.managers.PostgresManager;
import org.example.services.task.TaskWebServiceImpl;
import org.example.services.user.UserWebServiceImpl;

import java.sql.SQLException;


public class Main {
    public static final String BASE_URL = "http://localhost:%s/wss/";

    public static void main(String[] args) throws SQLException {
        if (Settings.ENABLE_MIGRATIONS) {
            MigrationManager migrationManager = new MigrationManager();
            migrationManager.dropMigrations();
            migrationManager.runMigrations();
        }

//        Endpoint.publish(getUrl(8002, "user"), new UserWebServiceImpl());
//        Endpoint.publish(getUrl(8003, "task"), new TaskWebServiceImpl());
//        System.out.println("Server started");
    }

    private static String getUrl(int port, String Endpoint) {
        return String.format(BASE_URL, port) + Endpoint;
    }
}