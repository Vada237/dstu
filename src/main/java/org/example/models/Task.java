package org.example.models;

import java.util.Date;

public class Task {
    private int Id;
    private String title;
    private Date startTime;
    private Date finishTime;
    private Date trackedTime;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getTrackedTime() {
        return trackedTime;
    }

    public void setTrackedTime(Date trackedTime) {
        this.trackedTime = trackedTime;
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

    public Task(int id, String title, Date startTime, Date finishTime, Date trackedTime, String status, User user) {
        Id = id;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.trackedTime = trackedTime;
        this.status = status;
        this.user = user;
    }

    private User user;
}
