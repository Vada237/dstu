package org.example.services.userTask;


import org.example.Settings;
import org.example.enums.TaskStatus;
import org.example.managers.PostgresManager;
import org.example.models.Task;
import org.example.models.UserTask;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import javax.jws.WebService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executor;
import java.sql.Connection;

@WebService(endpointInterface = "org.example.services.userTask.UserTaskWebService")
public class UserTaskWebServiceImpl implements UserTaskWebService{
    private final ExecutorService executor = Executors.newFixedThreadPool(Settings.MAX_COUNT_THREAD);

    @Override
    public void trackTime(Task task,int userId, int time, int progress) throws SQLException {
        Connection connection = PostgresManager.conn;
        connection.setAutoCommit(false);

        CompletableFuture<Void> addProgressFuture = runAsyncTask(() -> {
             addProgress(task, progress); return null;
            }, executor);

        CompletableFuture<Void> addPivotProgressFuture = runAsyncTask(() -> {
            addPivotProgress(task, userId, time, progress); return null;
        }, executor);
        
        CompletableFuture<Void> setTotalProgressFuture = runAsyncTask(() -> {
            task.setTotalProgress(task.getTotalProgress() + progress); return null;
        }, executor);
    
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(addProgressFuture, addPivotProgressFuture, setTotalProgressFuture);
        
        allFutures.thenRun(() -> {
            try {
                checkProgress(task);                
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        allFutures.join();
    }

    private void checkProgress(Task task) throws SQLException {
        int totalTrackedTime = 0;
        List<UserTask> userTasks = UserTask.getByTaskId(task.getId());

        for (UserTask userTask : userTasks) {
            totalTrackedTime += userTask.getTrackedTime();
        }

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(task.getStartTime(), pattern);
        LocalDateTime endDate = LocalDateTime.parse(task.getFinishTime(), pattern);

        LocalDateTime currentDate = startDate.plusSeconds(totalTrackedTime);

        if (currentDate.isAfter(endDate)) {
            Task.updateStatus(task.getId(), TaskStatus.EXPIRED.name());
        }

        if (task.getTotalProgress() == 100) {
            Task.updateStatus(task.getId(), TaskStatus.COMPLETED.name());
        }
    }

    private void addProgress(Task task, int progress) throws SQLException, InterruptedException {
        Task.UpdateProgress(task, progress);
    }

    private void addPivotProgress(Task task,int userId, int time, int progress) throws SQLException {
        UserTask.insert(Map.ofEntries(
            Map.entry("user_id", userId),
            Map.entry("task_id", task.getId()),
            Map.entry("tracked_time", time),
            Map.entry("total_progress", progress)
        ));


    }

    private <T> CompletableFuture<Void> runAsyncTask(Callable<T> task, Executor executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                task.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, executor);
    }
}