package org.example.repositories;

import org.example.models.Project;

public class ProjectRepository extends Repository<Project> {
    public ProjectRepository() {
        super();
        this.objects.put(1, new Project(1, "Docubiz.fr"));
        this.objects.put(2, new Project(2, "Datapult.ai"));
        this.objects.put(3, new Project(3, "startupshow.tv"));
        this.objects.put(4, new Project(4, "graf.ru"));
        this.objects.put(5, new Project(5, "adm-monk.ci"));
    }
}
