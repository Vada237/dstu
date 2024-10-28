package org.example.clients;

import org.example.models.Task;
import org.example.services.task.TaskWebService;
import org.example.services.task.TaskWebServiceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
        Task[] tasksByUser = taskService.getByUserId(3);

        for (Task row: tasksByUser) {
            System.out.println(row);
        }
    }
}
