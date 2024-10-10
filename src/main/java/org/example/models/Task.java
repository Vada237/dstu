package org.example.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private int Id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private String status;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Task(int id, String title, LocalDateTime startTime, LocalDateTime finishTime, String status, User user) {
        Id = id;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.user = user;
    }

    private User user;
}
