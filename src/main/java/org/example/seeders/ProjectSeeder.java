package org.example.seeders;

import org.example.models.Project;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

public class ProjectSeeder {
    public static void run() throws SQLException {
        Project.insert(Map.ofEntries(
                Map.entry("title", "docubiz.fr"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.OCTOBER, 5, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.DECEMBER, 19, 10, 0, 0))
                )
        );
        Project.insert(Map.ofEntries(
                Map.entry("title", "datapult.ai"),
                Map.entry("start_time", LocalDateTime.of(2023, Month.OCTOBER, 1, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.APRIL, 30, 10, 0, 0))
                )
        );
        Project.insert(Map.ofEntries(
                Map.entry("title", "startupshow.tv"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.FEBRUARY, 10, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.JULY, 10, 10, 0, 0))
                )
        );
        Project.insert(Map.ofEntries(
                Map.entry("title", "graf.ru"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 4, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 25, 10, 0, 0))
                )
        );
        Project.insert(Map.ofEntries(
                Map.entry("title", "adm-monk.ci"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.OCTOBER, 1, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.NOVEMBER, 30, 10, 0, 0))
                )
        );
    }
}
