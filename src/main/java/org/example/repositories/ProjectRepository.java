package org.example.repositories;

import org.example.models.Project;

public class ProjectRepository extends Repository<Project> {
    public ProjectRepository() {
        super(Project.class);
    }
}
