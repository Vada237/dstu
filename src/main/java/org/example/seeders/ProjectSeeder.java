package org.example.seeders;

import org.example.models.Project;

import java.sql.SQLException;
import java.util.Map;

public class ProjectSeeder {
    public static void run() throws SQLException {
        Project.insert(Map.ofEntries(Map.entry("title", "docubiz.fr")));
        Project.insert(Map.ofEntries(Map.entry("title", "datapult.ai")));
        Project.insert(Map.ofEntries(Map.entry("title", "startupshow.tv")));
        Project.insert(Map.ofEntries(Map.entry("title", "graf.ru")));
        Project.insert(Map.ofEntries(Map.entry("title", "adm-monk.ci")));
    }
}
