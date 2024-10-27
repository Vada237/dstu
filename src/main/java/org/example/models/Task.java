package org.example.models;

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
    private Project project;

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
        return getCollection(Model.getById(id, tableName)).getFirst();
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

