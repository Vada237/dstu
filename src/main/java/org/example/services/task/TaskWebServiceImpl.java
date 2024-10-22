package org.example.services.task;

import org.example.models.Task;
import org.example.repositories.ProjectRepository;
import org.example.repositories.TaskRepository;
import org.example.repositories.UserRepository;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "org.example.services.task.TaskWebService")
public class TaskWebServiceImpl implements TaskWebService {
    public TaskRepository taskRepository = new TaskRepository(new UserRepository(), new ProjectRepository());

    @Override
    public Task getById(int id) {
        return this.taskRepository.getById(id);
    }

    @Override
    public Task[] getByProjectId(int projectId) {
        return this.taskRepository.getByProjectId(projectId);
    }

    @Override
    public Task[] getByUserId(int userId) {
        return this.taskRepository.getByUserId(userId);
    }
}
