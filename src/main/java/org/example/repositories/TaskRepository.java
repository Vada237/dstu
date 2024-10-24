package org.example.repositories;

import org.example.enums.TaskStatus;
import org.example.models.Task;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class TaskRepository extends Repository<Task>{
    public TaskRepository() {
        super(Task.class);
    }

    public Task[] getByProjectId(int projectId) {
        return new Task[0];
    }

    public Task[] getByUserId(int userId) {
        return new Task[0];
    }
}
