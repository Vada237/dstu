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
        
        System.out.println("Эксперимент проводится на сгенерированных записях\\n");
        
        runIteration(
            userTaskservice, taskService, 1, 1,4000, 20,
        "Добавляем итерацию у задачи с id 1. В результате получаем не просроченную задачу."
        );
        
        runIteration(
            userTaskservice, taskService, 1, 1,666666, 1,
            "Добавляем итерацию у задачи с id 1. В результате получаем просроченную задачу."
        );

        runIteration(
            userTaskservice, taskService, 1, 1,0, 140,
            "Добавляем итерацию у задачи с id 1. В результате получаем просроченную, но завершенную задачу."
        );

        System.out.println("Заполнение задач для графика burndown");
        runIteration(userTaskservice, taskService, 5, 2, 1800, 100, "");
        runIteration(userTaskservice, taskService, 6, 2, 1800, 100, "");
        runIteration(userTaskservice, taskService, 7, 4, Time.SECONDS_IN_DAYS * 2, 80, "");
        runIteration(userTaskservice, taskService, 7, 4, Time.SECONDS_IN_DAYS, 20, "");
        runIteration(userTaskservice, taskService, 7, 4, Time.SECONDS_IN_DAYS, 20, "");
        runIteration(userTaskservice, taskService, 8, 3, Time.SECONDS_IN_DAYS * 3, 100, "");
        runIteration(userTaskservice, taskService, 9, 4, Time.SECONDS_IN_DAYS * 5, 100, "");
        runIteration(userTaskservice, taskService, 10, 3, Time.SECONDS_IN_DAYS * 2, 100, "");
        runIteration(userTaskservice, taskService, 11, 1, Time.SECONDS_IN_DAYS * 4, 100, "");
        runIteration(userTaskservice, taskService, 12, 4, Time.SECONDS_IN_DAYS * 3, 100, "");
        runIteration(userTaskservice, taskService, 13, 4, Time.SECONDS_IN_DAYS, 100, "");
    }

    private static void runIteration(
        UserTaskWebServiceImpl userTaskWebServiceImpl,
        TaskWebServiceImpl taskWebServiceImpl,
        int task_id,
        int userId,
        int time,
        int progress,
        String message
    ) throws SQLException {
        System.out.println(message);        
        System.out.println();
        userTaskWebServiceImpl.trackTime(taskWebServiceImpl.getById(task_id), userId, time, progress);
        Task task = taskWebServiceImpl.getById(task_id);
        System.out.println(task);
        System.out.println();
    }
}
