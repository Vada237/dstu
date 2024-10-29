package org.example.services.userTask;


import org.example.Settings;
import org.example.models.Task;
import org.example.models.UserTask;


import java.util.concurrent.Future;
import javax.jws.WebService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.sql.SQLException;
import java.util.Map;


@WebService(endpointInterface = "org.example.services.userTask.UserTaskWebService")
public class UserTaskWebServiceImpl implements UserTaskWebService{
    private ExecutorService executor = Executors.newFixedThreadPool(Settings.MAX_COUNT_THREAD);


    @Override
    public void trackTime(Task task, int time, int progress) throws SQLException {
        executor.submit(() -> addProgress(task, progress));
        executor.submit(() -> addPivotProgress(task, time, progress));


        checkProgress(task);


    }


    @Override
    public void checkProgress(Task task) throws SQLException {


    }


    @Override
    public Future<Void> addProgress(Task task, int progress) throws SQLException {
        Task.UpdateProgress(task, progress);
        return null;
    }


    @Override
    public void updateStatus(Task task) throws SQLException {


    }


    @Override
    public Future<Void> addPivotProgress(Task task, int time, int progress) throws SQLException {
        UserTask.insert(Map.ofEntries(
            Map.entry("user_id", task.getUserId()),
            Map.entry("task_id", task.getId()),
            Map.entry("tracked_time", time),
            Map.entry("total_progress", progress)
        ));


        return null;
    }
}