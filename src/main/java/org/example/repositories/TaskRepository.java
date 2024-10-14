package org.example.repositories;

import org.example.enums.TaskStatus;
import org.example.models.LocalDateTimeWrapper;
import org.example.models.Task;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class TaskRepository extends Repository<Task>{
    public TaskRepository(UserRepository userRepository, ProjectRepository projectRepository) {
        super();
        this.objects.put(
                1, new Task(
                        1,
                        "Добавить платежную систему SBER PAY",
                        new LocalDateTimeWrapper(LocalDateTime.of(2019, Month.OCTOBER, 10, 10, 0, 0)),
                        new LocalDateTimeWrapper(LocalDateTime.of(2019, Month.OCTOBER, 11, 10, 0, 0)),
                        TaskStatus.CLOSE.name(),
                        userRepository.getById(1),
                        projectRepository.getById(1)
                )
        );

        this.objects.put(2, new Task(
                2,
                "Починить прод",
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.OCTOBER, 18, 10, 0, 0)),
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.OCTOBER, 19, 10, 0, 0)),
                TaskStatus.OPEN.name(),
                userRepository.getById(2),
                projectRepository.getById(1)
                )
        );

        this.objects.put(3, new Task(
                3,
                "Добавить двухэтапную авторизацию",
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.NOVEMBER, 24, 15, 30, 0)),
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.NOVEMBER, 29, 15, 30, 0)),
                TaskStatus.OPEN.name(),
                userRepository.getById(3),
                projectRepository.getById(2)
                )
        );

        this.objects.put(4, new Task(
                4,
                "Добавить эндпоинт, который выводит список пользователей",
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.APRIL, 2, 8, 30, 0)),
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.APRIL, 3, 11, 30, 0)),
                TaskStatus.COMPLETED.name(),
                userRepository.getById(3),
                projectRepository.getById(3)
                )
        );

        this.objects.put(5, new Task(
                5,
                "Выбросить мусор",
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.JUNE, 2, 8, 30, 0)),
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.JUNE, 3, 11, 30, 0)),
                TaskStatus.COMPLETED.name(),
                userRepository.getById(4),
                projectRepository.getById(4)
                )
        );

        this.objects.put(6, new Task(
                6,
                "Купить пива тимлиду",
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.JUNE, 2, 8, 30, 0)),
                new LocalDateTimeWrapper(LocalDateTime.of(2024, Month.JUNE, 3, 11, 30, 0)),
                TaskStatus.COMPLETED.name(),
                userRepository.getById(4),
                projectRepository.getById(4)
                )
        );
    }

    public Task[] getByProjectId(int projectId) {
        ArrayList<Task> tasks = new ArrayList<>();

        for (Task task : this.objects.values()) {
            if (task.getProject().getId() == projectId) {
                tasks.add(task);
            }
        }

        return tasks.toArray(new Task[0]);
    }

    public Task[] getByUserId(int userId) {
        ArrayList<Task> tasks = new ArrayList<>();

        for (Task task : this.objects.values()) {
            if (task.getUser().getId() == userId) {
                tasks.add(task);
            }
        }

        return tasks.toArray(new Task[0]);
    }
}
