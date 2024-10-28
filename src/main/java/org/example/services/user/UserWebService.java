package org.example.services.user;

import org.example.models.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserWebService {
    @WebMethod
    public User getUserById(int id) throws SQLException;
}