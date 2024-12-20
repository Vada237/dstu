package org.example;

import javax.xml.ws.Endpoint;

import org.example.services.project.ProjectWebServiceImpl;
import org.example.services.task.TaskWebServiceImpl;
import org.example.services.user.UserWebServiceImpl;
import org.example.services.userTask.UserTaskWebServiceImpl;



public class Main {
    public static final String BASE_URL = "http://localhost:%s/wss/";

    public static void main(String[] args) {
        Endpoint.publish(getUrl(8010, "user"), new UserWebServiceImpl());
        Endpoint.publish(getUrl(8011, "task"), new TaskWebServiceImpl());
        Endpoint.publish(getUrl(8012, "userTask"), new UserTaskWebServiceImpl());
        Endpoint.publish(getUrl(8013, "project"), new ProjectWebServiceImpl());
        System.out.println("Server started");
    }

    private static String getUrl(int port, String Endpoint) {
        return String.format(BASE_URL, port) + Endpoint;
    }
}