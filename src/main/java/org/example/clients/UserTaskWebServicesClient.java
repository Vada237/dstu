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
        runIteration(userTaskservice, taskService, 4, 4, Time.SECONDS_IN_HOURS * 2, 25, "2024-03-15T10:00:00");
        runIteration(userTaskservice, taskService, 4, 4, Time.SECONDS_IN_HOURS * 3, 75, "2024-03-18T10:00:00");

        runIteration(userTaskservice, taskService, 3, 4, Time.SECONDS_IN_HOURS * 2, 20, "2024-03-11T10:00:00");
        runIteration(userTaskservice, taskService, 3, 4, Time.SECONDS_IN_HOURS * 4, 60, "2024-03-12T10:00:00");
        runIteration(userTaskservice, taskService, 3, 4, Time.SECONDS_IN_HOURS * 2, 20, "2024-03-12T18:00:00");

        runIteration(userTaskservice, taskService, 1, 4, Time.SECONDS_IN_HOURS * 2, 10, "2024-03-04T14:00:00");
        runIteration(userTaskservice, taskService, 1, 4, Time.SECONDS_IN_HOURS * 4, 40, "2024-03-05T14:00:00");
        runIteration(userTaskservice, taskService, 1, 4, Time.SECONDS_IN_HOURS * 3, 35, "2024-03-06T14:00:00");
        runIteration(userTaskservice, taskService, 1, 4, Time.SECONDS_IN_HOURS * 3, 15, "2024-03-07T10:00:00");

        runIteration(userTaskservice, taskService, 1, 4, Time.SECONDS_IN_HOURS * 5, 100, "2024-03-15T12:00:00");

        runIteration(userTaskservice, taskService, 2, 3, Time.SECONDS_IN_HOURS * 2, 75, "2024-03-12T12:00:00");
        runIteration(userTaskservice, taskService, 2, 3, Time.SECONDS_IN_HOURS, 25, "2024-03-13T15:00:00");

        runIteration(userTaskservice, taskService, 6, 3, Time.SECONDS_IN_HOURS * 3, 80, "2024-03-21T15:00:00");
        runIteration(userTaskservice, taskService, 6, 3, Time.SECONDS_IN_HOURS, 20, "2024-03-21T15:00:00");

        runIteration(userTaskservice, taskService, 7, 3, Time.SECONDS_IN_HOURS, 40, "2024-03-22T10:00:00");
        runIteration(userTaskservice, taskService, 7, 3, Time.SECONDS_IN_HOURS * 3, 40, "2024-03-22T11:00:00");

        runIteration(userTaskservice, taskService, 7, 3, Time.SECONDS_IN_HOURS * 3, 20, "2024-03-22T15:00:00");
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
