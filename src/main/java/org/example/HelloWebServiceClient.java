package org.example;

import org.example.models.User;
import org.example.services.UserWebService;

import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:1986/wss/user?wsdl");
        QName qname = new QName("http://services.example.org/", "UserWebServiceImplService");
        Service service = Service.create(url, qname);
        UserWebService userService = service.getPort(UserWebService.class);
        System.out.println(userService.getUserById(1));
    }
}