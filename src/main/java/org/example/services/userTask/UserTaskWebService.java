package org.example.services.userTask;

import org.example.models.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserTaskWebService {
    @WebMethod
    public void trackTime(Task task,int userId, int time, int progress, String createdAt) throws SQLException;
}
