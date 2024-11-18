package org.example.services.project;

import org.example.models.Project;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.services.project.ProjectWebService")
public class ProjectWebServiceImpl implements ProjectWebService {
    @Override
    public void addProject(Project project) throws SQLException {
        Project.insert(Map.ofEntries(
                        Map.entry("title", project.getTitle()),
                        Map.entry("start_time", LocalDateTime.parse(project.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))),
                        Map.entry("end_time", LocalDateTime.parse(project.getFinishTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))),
                        Map.entry("count_hours", project.getTotalHours())
                )
        );
    }
}
