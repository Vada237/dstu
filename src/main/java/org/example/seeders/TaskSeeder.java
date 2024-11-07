package org.example.seeders;

import org.example.enums.TaskStatus;
import org.example.models.Task;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

public class TaskSeeder {
    public static void run() throws SQLException {
        Task.insert(Map.ofEntries(
                        Map.entry("title", "Спроектировать архитектуру базы данных"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 4, 12, 0, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 8, 12, 0, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 1),
                        Map.entry("current_user_id", 4),
                        Map.entry("total_progress", 0),
                        Map.entry("count_hours", 10)
                )
        );

        Task.insert(Map.ofEntries(
                Map.entry("title", "Нарисовать дизайн"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 12, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 14, 10, 0, 0)),
                Map.entry("status", TaskStatus.OPEN.name()),
                Map.entry("project_id", 1),
                Map.entry("current_user_id", 3),
                Map.entry("count_hours", 4),
                Map.entry("total_progress", 0)
                )
        );

        Task.insert(Map.ofEntries(
                Map.entry("title", "Спроектировать архитектуру backend'а"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 9, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 13, 10, 0, 0)),
                Map.entry("status", TaskStatus.OPEN.name()),
                Map.entry("project_id", 1),
                Map.entry("current_user_id", 4),
                Map.entry("count_hours", 6),
                Map.entry("total_progress", 0)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Разработать фронтенд"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 15, 10, 0, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 20, 10, 0, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 1),
                        Map.entry("current_user_id", 4),
                        Map.entry("count_hours", 5),
                        Map.entry("total_progress", 0)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Разработать бэкенд"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 14, 10, 0, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 19, 10, 0, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 1),
                        Map.entry("current_user_id", 4),
                        Map.entry("count_hours", 5),
                        Map.entry("total_progress", 0)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Протестировать приложение"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 21, 10, 0, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 22, 10, 0, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 1),
                        Map.entry("current_user_id", 3),
                        Map.entry("count_hours", 4),
                        Map.entry("total_progress", 0)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Написать документацию"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.MARCH, 22, 10, 0, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.MARCH, 22, 19, 0, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 1),
                        Map.entry("current_user_id", 2),
                        Map.entry("count_hours", 6),
                        Map.entry("total_progress", 0)
                )
        );
    }
}
