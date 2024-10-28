package org.example.clients;

import org.example.enums.TaskStatus;
import org.example.models.Project;
import org.example.models.Task;
import org.example.models.User;
import org.example.services.task.TaskWebService;
import org.example.services.task.TaskWebServiceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class TaskWebServicesClient {
    public static void main(String[] args) throws MalformedURLException, SQLException {
        URL url = new URL("http://localhost:8003/wss/task?wsdl");
        QName qname = new QName("http://task.services.example.org/", "TaskWebServiceImplService");

        Service service = Service.create(url, qname);
        TaskWebService taskService = service.getPort(TaskWebService.class);

        System.out.println("Получение задач по проекту");
        Task[] tasksByProjects = taskService.getByProjectId(1);

        for (Task row: tasksByProjects) {
            System.out.println(row);
        }

        System.out.println();
        System.out.println("Получение задачи по id");
        System.out.println(taskService.getById(1));

        System.out.println();
        System.out.println("Получение задач у пользователя");
        Task[] tasksByUser = taskService.getByUserId(2);

        for (Task row: tasksByUser) {
            System.out.println(row);
        }

        System.out.println();
        System.out.println("Создание задачи пользователю с id = 3 для проекта с id = 1");

        taskService.addTask(new Task(
                "Тестовая задача",
                LocalDateTime.of(2024, Month.NOVEMBER, 1, 12, 0, 0).toString(),
                LocalDateTime.of(2024, Month.NOVEMBER, 2, 12, 0, 0).toString(),
                TaskStatus.OPEN.name(),
                User.getById(3),
                Project.getById(1)
        ));

        System.out.println("Получение созданной задачи по названию");
        Task task = taskService.getByTitle("Тестовая задача")[0];
        System.out.println(task);

        System.out.println("Удаление этой задачи");
        taskService.deleteTaskById(task.getId());
    }
}
