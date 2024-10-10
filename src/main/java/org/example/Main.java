package org.example;

import javax.xml.ws.Endpoint;
import org.example.services.UserWebServiceImpl;


public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1986/wss/user", new UserWebServiceImpl());
    }
}