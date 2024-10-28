package org.example.models;

import org.example.managers.PostgresManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task extends Model {
    public static String tableName = "tasks";
    private int id;
    private String title;
    private String startTime;
    private String finishTime;
    private String status;
    private User user;
    private int userId;
    private Project project;
    private int projectId;
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Task(
            int id,
            String title,
            String startTime,
            String finishTime,
            String status,
            User user,
            Project project
    ) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.user = user;
        this.project = project;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", project=" + project +
                '}';
    }

    public static void insert(Map<String, Object> params) throws SQLException {
        Model.insert(params, tableName);
    }

    public static List<Task> all() throws SQLException {
        return getCollection(Model.all(tableName));
    }

    public static void delete(int id) throws SQLException {
        Model.delete(id, tableName);
    }

    public static Task getById(int id) throws SQLException {
        return getCollection(Model.getById(id, tableName)).get(0);
    }

    public static List<Task> getByUserId(int userId) throws SQLException {
        Object[] params = new Object[1];
        params[0] = userId;

        return getCollection(PostgresManager.executeSelect("SELECT * FROM " + tableName + " WHERE current_user_id = ?", params));
    }

    public static List<Task> getByProjectId(int projectId) throws SQLException {
        Object[] params = new Object[1];
        params[0] = projectId;

        return getCollection(PostgresManager.executeSelect("SELECT * FROM " + tableName + " WHERE project_id = ?", params));
    }

    public static List<Task> getCollection(ResultSet data) throws SQLException {
        List<Task> tasks = new ArrayList<Task>();

        while (data.next()) {
            Project project = Project.getById(data.getInt("project_id"));
            User currentUser = User.getById(data.getInt("current_user_id"));

            tasks.add(new Task(
                    data.getInt("id"),
                    data.getString("title"),
                    data.getString("start_time"),
                    data.getString("end_time"),
                    data.getString("status"),
                    currentUser,
                    project
            ));
        }

        return tasks;
    }
}

