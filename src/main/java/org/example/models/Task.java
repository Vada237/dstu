package org.example.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private LocalDateTimeWrapper startTime;
    private LocalDateTimeWrapper finishTime;
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
            LocalDateTimeWrapper startTime,
            LocalDateTimeWrapper finishTime,
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
        this.startTime = new LocalDateTimeWrapper();
        this.finishTime = new LocalDateTimeWrapper();
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
}

