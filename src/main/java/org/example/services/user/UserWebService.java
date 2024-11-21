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
    @WebMethod
    public void createUser(User user) throws SQLException;
    @WebMethod
    public void deleteUserById(int id) throws SQLException;
    @WebMethod
    public User[] getByFirstAndSecondName(String firstName, String secondName) throws SQLException;
    @WebMethod
    public User[] getAll() throws SQLException;
}