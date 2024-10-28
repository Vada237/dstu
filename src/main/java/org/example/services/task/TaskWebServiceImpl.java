package org.example.services.task;

import org.example.models.Task;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.Map;

@WebService(endpointInterface = "org.example.services.task.TaskWebService")
public class TaskWebServiceImpl implements TaskWebService {
    @Override
    public Task getById(int id) throws SQLException {
        return Task.getById(id);
    }

    @Override
    public Task[] getByProjectId(int projectId) throws SQLException {
        return Task.getByProjectId(projectId).toArray(new Task[0]);
    }

    @Override
    public Task[] getByUserId(int userId) throws SQLException {
        return Task.getByUserId(userId).toArray(new Task[0]);
    }

    @Override
    public void addTask(Task task) throws SQLException {
        Task.insert(Map.ofEntries(
                Map.entry("title", task.getTitle()),
                Map.entry("start_time", task.getStartTime()),
                Map.entry("finish_time", task.getFinishTime()),
                Map.entry("status", task.getStatus()),
                Map.entry("project_id", task.getProjectId()),
                Map.entry("current_user_id", task.getUserId())
        ));
    }

    @Override
    public void deleteTaskById(int id) throws SQLException {
        Task.delete(id);
    }
}
