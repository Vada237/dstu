package org.example.services.task;

import org.example.models.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.ArrayList;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface TaskWebService {
    @WebMethod
    public Task getById(int id) throws SQLException;
    @WebMethod
    public Task[] getByProjectId(int projectId) throws SQLException;
    @WebMethod
    public Task[] getByUserId(int userId) throws SQLException;
    @WebMethod
    public void addTask(Task data) throws SQLException;
    @WebMethod
    public void deleteTaskById(int id) throws SQLException;
    @WebMethod
    public Task[] getByTitle(String title) throws SQLException;
}
