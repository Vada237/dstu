package org.example.services.task;

import org.example.models.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface TaskWebService {
    @WebMethod
    public Task getById(int id);
    @WebMethod
    public Task[] getByProjectId(int projectId);
    @WebMethod
    public Task[] getByUserId(int userId);
}
