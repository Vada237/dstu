package org.example.services.userTask;

import org.example.models.Task;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.concurrent.Future;
import java.sql.SQLException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserTaskWebService {
    @WebMethod
    public void trackTime(Task task, int time, int progress) throws SQLException;
    @WebMethod
    public void checkProgress(Task task) throws SQLException;
    @WebMethod
    public Future<Void> addProgress(Task task, int progress) throws SQLException;
    @WebMethod
    public Future<Void> addPivotProgress(Task task, int time, int progress) throws SQLException;
    @WebMethod
    public void updateStatus(Task task) throws SQLException;
}
