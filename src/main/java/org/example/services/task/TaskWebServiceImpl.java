package org.example.services.task;

import org.example.models.Task;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.services.task.TaskWebService")
public class TaskWebServiceImpl implements TaskWebService {
    @Override
    public Task getById(int id) {
        return new Task();
    }

    @Override
    public Task[] getByProjectId(int projectId) {
        return new Task[1];
    }

    @Override
    public Task[] getByUserId(int userId) {
        return new Task[1];
    }
}
