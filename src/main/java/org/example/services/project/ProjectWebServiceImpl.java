package org.example.services.project;

import org.example.models.Project;

import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.services.project.ProjectWebService")
public class ProjectWebServiceImpl implements ProjectWebService{
    @Override
    public void addProject(Project project) {
        Project.insert(Map.ofEntries(
            Map.entry("title", project.getTitle()),
            Map.entry("start_time", project.)
        ));
    }
}
