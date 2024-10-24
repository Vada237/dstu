package org.example.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class UserTask extends Model{
    public static String tableName = "user_tasks";

    private int id;
    private User user;
    private int userId;
    private Task task;
    private int taskId;
    private Timestamp trackedTime;
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

    public Timestamp getTrackedTime() {
        return trackedTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTrackedTime(Timestamp trackedTime) {
        this.trackedTime = trackedTime;
    }

    public UserTask(int userId, int taskId, Timestamp trackedTime) {
        this.userId = userId;
        this.taskId = taskId;
        this.trackedTime = trackedTime;
    }

    public static void insert(Map<String, Object> params) throws SQLException {
        Model.insert(params, tableName);
    }
}
