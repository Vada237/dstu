package org.example.repositories;

import org.example.Enums.TaskStatus;
import org.example.models.Task;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;

public class TaskRepository {
    private final HashMap<Integer, Task> tasks;

    public TaskRepository(UserRepository userRepository) {
        this.tasks = new HashMap<Integer, Task>();

        this.tasks.put(
                1, new Task(
                        1,
                        "Добавить платежную систему SBER PAY",
                        LocalDateTime.of(2019, Month.OCTOBER, 10, 10, 0, 0),
                        LocalDateTime.of(2019, Month.OCTOBER, 11, 10, 0, 0),
                        TaskStatus.CLOSE.name(),
                        userRepository.getById(1)
                )
        );

        this.tasks.put(2, new Task(
                2,
                "Починить прод",
                LocalDateTime.of(2024, Month.OCTOBER, 18, 10, 0, 0),
                LocalDateTime.of(2024, Month.OCTOBER, 19, 10, 0, 0),
                TaskStatus.OPEN.name(),
                userRepository.getById(2))
        );

        this.tasks.put(3, new Task(
                3,
                "Добавить двухэтапную авторизацию",
                LocalDateTime.of(2024, Month.NOVEMBER, 24, 15, 30, 0),
                LocalDateTime.of(2024, Month.NOVEMBER, 29, 15, 30, 0),
                TaskStatus.OPEN.name(),
                userRepository.getById(3))
        );

        this.tasks.put(4, new Task(
                4,
                "Добавить эндпоинт, который выводит список пользователей",
                LocalDateTime.of(2024, Month.APRIL, 2, 8, 30, 0),
                LocalDateTime.of(2024, Month.APRIL, 3, 11, 30, 0),
                TaskStatus.COMPLETED.name(),
                userRepository.getById(3))
        );

        this.tasks.put(5, new Task(
                5,
                "Выбросить мусор",
                LocalDateTime.of(2024, Month.JUNE, 2, 8, 30, 0),
                LocalDateTime.of(2024, Month.JUNE, 3, 11, 30, 0),
                TaskStatus.COMPLETED.name(),
                userRepository.getById(4))
        );

        this.tasks.put(6, new Task(
                6,
                "Купить пива тимлиду",
                LocalDateTime.of(2024, Month.JUNE, 2, 8, 30, 0),
                LocalDateTime.of(2024, Month.JUNE, 3, 11, 30, 0),
                TaskStatus.COMPLETED.name(),
                userRepository.getById(4))
        );
    }

}
