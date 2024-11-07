package org.example.clients;

import org.example.models.Task;
import org.example.services.task.TaskWebServiceImpl;
import org.example.services.userTask.UserTaskWebServiceImpl;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.example.consts.Time;

public class UserTaskWebServicesClient {
    public static void main(String[] args) throws MalformedURLException, SQLException {
        UserTaskWebServiceImpl userTaskservice = new UserTaskWebServiceImpl();
        TaskWebServiceImpl taskService = new TaskWebServiceImpl();

        System.out.println("Заполнение задач для графика burndown");
        runIteration(userTaskservice, taskService, 1, 2, 1800, 100, "2024-03-04T10:00:00");
        runIteration(userTaskservice, taskService, 2, 2, 1800, 100, "2024-03-04T10:30:00");
        runIteration(userTaskservice, taskService, 3, 4, Time.SECONDS_IN_DAYS, 80, "2024-03-04T12:00:00");
        runIteration(userTaskservice, taskService, 3, 4, Time.SECONDS_IN_DAYS, 10, "2024-03-06T12:00:00");
        runIteration(userTaskservice, taskService, 3, 4, Time.SECONDS_IN_DAYS, 10, "2024-03-07T12:00:00");
        runIteration(userTaskservice, taskService, 4, 3, Time.SECONDS_IN_DAYS, 33, "2024-03-12T10:00:00");
        runIteration(userTaskservice, taskService, 4, 3, Time.SECONDS_IN_DAYS, 17, "2024-03-13T10:00:00");
        runIteration(userTaskservice, taskService, 4, 3, Time.SECONDS_IN_DAYS, 50, "2024-03-14T10:00:00");

        runIteration(userTaskservice, taskService, 5, 4, Time.SECONDS_IN_DAYS, 15, "2024-03-08T10:00:00");
        runIteration(userTaskservice, taskService, 5, 4, Time.SECONDS_IN_DAYS, 25, "2024-03-09T10:00:00");
        runIteration(userTaskservice, taskService, 5, 4, Time.SECONDS_IN_DAYS, 5, "2024-03-10T10:00:00");
        runIteration(userTaskservice, taskService, 5, 4, Time.SECONDS_IN_DAYS, 40, "2024-03-11T10:00:00");
        runIteration(userTaskservice, taskService, 5, 4, Time.SECONDS_IN_DAYS, 15, "2024-03-12T10:00:00");

        runIteration(userTaskservice, taskService, 6, 3, Time.SECONDS_IN_DAYS, 70, "2024-03-16T10:00:00");
        runIteration(userTaskservice, taskService, 6, 3, Time.SECONDS_IN_DAYS, 30, "2024-03-17T10:00:00");

        runIteration(userTaskservice, taskService, 7, 1, Time.SECONDS_IN_DAYS, 30, "2024-03-14T10:00:00");
        runIteration(userTaskservice, taskService, 7, 1, Time.SECONDS_IN_DAYS, 40, "2024-03-15T10:00:00");
        runIteration(userTaskservice, taskService, 7, 1, Time.SECONDS_IN_DAYS, 10, "2024-03-16T10:00:00");
        runIteration(userTaskservice, taskService, 7, 1, Time.SECONDS_IN_DAYS, 20, "2024-03-17T10:00:00");

        runIteration(userTaskservice, taskService, 8, 4, Time.SECONDS_IN_DAYS, 100, "2024-03-14T10:00:00");
        runIteration(userTaskservice, taskService, 8, 4, Time.SECONDS_IN_DAYS, 100, "2024-03-15T10:00:00");
        runIteration(userTaskservice, taskService, 8, 4, Time.SECONDS_IN_DAYS, 100, "2024-03-16T10:00:00");

        runIteration(userTaskservice, taskService, 9, 4, Time.SECONDS_IN_DAYS, 100, "2024-03-17T10:00:00");
    }

    private static void runIteration(
            UserTaskWebServiceImpl userTaskWebServiceImpl,
            TaskWebServiceImpl taskWebServiceImpl,
            int task_id,
            int userId,
            int time,
            int progress,
            String createdAt
    ) throws SQLException {
        System.out.println();
        userTaskWebServiceImpl.trackTime(taskWebServiceImpl.getById(task_id), userId, time, progress, createdAt);
        Task task = taskWebServiceImpl.getById(task_id);
        System.out.println(task);
        System.out.println();
    }
}
