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
                Map.entry("title", "Добавить платежную систему SBER PAY"),
                Map.entry("start_time", LocalDateTime.of(2024, Month.OCTOBER, 18, 10, 0, 0)),
                Map.entry("end_time", LocalDateTime.of(2024, Month.OCTOBER, 19, 10, 0, 0)),
                Map.entry("status", TaskStatus.CLOSE.name()),
                Map.entry("project_id", 1),
                Map.entry("current_user_id", 1)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Починить прод"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.OCTOBER, 18, 10, 0, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.OCTOBER, 19, 10, 0, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 1),
                        Map.entry("current_user_id", 1)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Добавить двухэтапную авторизацию"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.NOVEMBER, 24, 15, 30, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.NOVEMBER, 29, 15, 30, 0)),
                        Map.entry("status", TaskStatus.OPEN.name()),
                        Map.entry("project_id", 2),
                        Map.entry("current_user_id", 4)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Добавить эндпоинт, который выводит список пользователей"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.APRIL, 2, 8, 30, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.APRIL, 3, 11, 30, 0)),
                        Map.entry("status", TaskStatus.COMPLETED.name()),
                        Map.entry("project_id", 3),
                        Map.entry("current_user_id", 3)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Выбросить мусор"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.JUNE, 2, 8, 30, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.JUNE, 3, 11, 30, 0)),
                        Map.entry("status", TaskStatus.COMPLETED.name()),
                        Map.entry("project_id", 4),
                        Map.entry("current_user_id", 2)
                )
        );

        Task.insert(Map.ofEntries(
                        Map.entry("title", "Купить пива тимлиду"),
                        Map.entry("start_time", LocalDateTime.of(2024, Month.JUNE, 2, 8, 30, 0)),
                        Map.entry("end_time", LocalDateTime.of(2024, Month.JUNE, 3, 11, 30, 0)),
                        Map.entry("status", TaskStatus.COMPLETED.name()),
                        Map.entry("project_id", 4),
                        Map.entry("current_user_id", 2)
                )
        );
    }
}
