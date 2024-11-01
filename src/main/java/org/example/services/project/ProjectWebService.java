package org.example.services.project;

import org.example.models.Project;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface ProjectWebService {
    @WebMethod
    public void addProject(Project project) throws SQLException;
}
