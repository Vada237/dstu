package org.example.seeders;
import java.sql.SQLException;

public class Seeder {
    public static void run() throws SQLException {
        UserSeeder.run();
        ProjectSeeder.run();
        TaskSeeder.run();
        UserTaskSeeder.run();
    }
}
