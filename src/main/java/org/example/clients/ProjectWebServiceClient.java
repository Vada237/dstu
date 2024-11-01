package org.example.clients;

import org.example.models.Project;
import org.example.models.User;
import org.example.services.project.ProjectWebService;
import org.example.services.user.UserWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;

public class ProjectWebServiceClient {
    public static void main(String[] args) throws MalformedURLException, SQLException {
        URL url = new URL("http://localhost:8005/wss/project?wsdl");
        QName qname = new QName("http://project.services.example.org/", "ProjectWebServiceImplService");
        Service service = Service.create(url, qname);

        ProjectWebService projectWebService = service.getPort(ProjectWebService.class);
        System.out.println("Создание проекта");
        projectWebService.addProject(new Project(
                0,
                "test",
                LocalDateTime.of(2024, Month.NOVEMBER, 1, 12, 0, 0).toString(),
                LocalDateTime.of(2024, Month.DECEMBER, 5, 12, 0, 0).toString()
        ));
    }
}
