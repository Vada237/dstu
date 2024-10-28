package org.example.clients;

import org.example.services.user.UserWebService;

import java.net.URL;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class UserWebServiceClient {
    public static void main(String[] args) throws MalformedURLException, SQLException {
        URL url = new URL("http://localhost:8002/wss/user?wsdl");
        QName qname = new QName("http://user.services.example.org/", "UserWebServiceImplService");
        Service service = Service.create(url, qname);
        UserWebService userService = service.getPort(UserWebService.class);
        System.out.println(userService.getUserById(2));
    }
}