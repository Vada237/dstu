package org.example.clients;

import org.example.models.Task;
import org.example.services.task.TaskWebServiceImpl;
import org.example.services.userTask.UserTaskWebServiceImpl;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class UserTaskWebServicesClient {
    public static void main(String[] args) throws MalformedURLException, SQLException {
        UserTaskWebServiceImpl userTaskservice = new UserTaskWebServiceImpl();
        TaskWebServiceImpl taskService = new TaskWebServiceImpl();
        
        System.out.println("Эксперимент проводится на сгенерированных записях\\n");
        
        runIteration(
            userTaskservice, taskService, 1, 4000, 20, 
        "Добавляем итерацию у задачи с id 1. В результате получаем не просроченную задачу."
        );
        
        runIteration(
            userTaskservice, taskService, 1, 666666, 1, 
            "Добавляем итерацию у задачи с id 1. В результате получаем просроченную задачу."
        );

        runIteration(
            userTaskservice, taskService, 1, 0, 140, 
            "Добавляем итерацию у задачи с id 1. В результате получаем просроченную, но завершенную задачу."
        );
    }

    private static void runIteration(
        UserTaskWebServiceImpl userTaskWebServiceImpl, TaskWebServiceImpl taskWebServiceImpl, int task_id, int time, int progress, String message
    ) throws SQLException {
        System.out.println(message);        
        System.out.println();
        userTaskWebServiceImpl.trackTime(taskWebServiceImpl.getById(1), time, progress);
        Task task = taskWebServiceImpl.getById(1);
        System.out.println(task);
        System.out.println();
    }
}
