package org.example.models;

import org.example.managers.PostgresManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserTask extends Model{
    public static String tableName = "user_tasks";

    private int id;
    private User user;
    private int userId;
    private Task task;
    private int taskId;
    private int trackedTime;
    private Date createdAt;
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Task getTask() {
        return task;
    }

    public int getTrackedTime() {
        return trackedTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTrackedTime(int trackedTime) {
        this.trackedTime = trackedTime;
    }

    public UserTask(int userId, int taskId, int trackedTime) {
        this.userId = userId;
        this.taskId = taskId;
        this.trackedTime = trackedTime;
    }

    public static void insert(Map<String, Object> params) throws SQLException {
        Model.insert(params, tableName);
    }

    public static List<UserTask> all() throws SQLException {
        return getCollection(Model.all(tableName));
    }

    public static UserTask getById(int id) throws SQLException {
        return getCollection(Model.getById(id, tableName)).getFirst();
    }

    public static void delete(int id) throws SQLException {
        Model.delete(id, tableName);
    }

    public static List<UserTask> getByUserId(int userId) throws SQLException {
        Object[] params = new Object[1];
        params[0] = userId;

        return getCollection(PostgresManager.executeSelect("SELECT * FROM " + tableName + "WHERE user_id = ?", params));
    }

    public static List<UserTask> getByProjectId(int projectId) throws SQLException {
        Object[] params = new Object[1];
        params[0] = projectId;

        return getCollection(PostgresManager.executeSelect("SELECT * FROM " + tableName + "WHERE project_id = ?", params));
    }

    private static List<UserTask> getCollection(ResultSet data) throws SQLException {
        List<UserTask> userTasks = new ArrayList<>();

        while (data.next()) {
            userTasks.add(new UserTask(
                    data.getInt("user_id"),
                    data.getInt("task_id"),
                    data.getInt("tracked_time")
            ));
        }

        return userTasks;
    }
}
