package org.example.services.task;

import org.example.enums.TaskStatus;
import org.example.models.Task;

import javax.jws.WebService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                Map.entry("start_time", LocalDateTime.parse(task.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))),
                Map.entry("end_time", LocalDateTime.parse(task.getFinishTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))),
                Map.entry("status", TaskStatus.OPEN.name()),
                Map.entry("project_id", task.getProjectId()),
                Map.entry("current_user_id", task.getUserId()),
                Map.entry("count_hours", task.getCountHours())
        ));
    }

    @Override
    public void deleteTaskById(int id) throws SQLException {
        Task.deleteById(id);
    }

    @Override
    public Task[] getByTitle(String title) throws SQLException {
        return Task.getByTitle(title).toArray(new Task[0]);
    }

    @Override
    public Task[] getAll() throws SQLException {
        return Task.all().toArray(new Task[0]);
    }
}
