package org.example.seeders;

import org.example.models.Project;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

public class ProjectSeeder {
    public static void run() throws SQLException {
        Project.insert(Map.ofEntries(
                Map.entry("title", "graf.ru"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 4, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 25, 10, 0, 0)),
                Map.entry("count_hours", 60)
                )
        );
    }
}
