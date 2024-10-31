package org.example.managers;

import org.example.migrations.*;

import java.sql.SQLException;

public class MigrationManager {
    public void runMigrations() throws SQLException {
        CreateUserMigration createUserMigration = new CreateUserMigration();
        createUserMigration.up();

        CreateProjectMigration createProjectMigration = new CreateProjectMigration();
        createProjectMigration.up();

        CreateTasksMigration createTasksMigration = new CreateTasksMigration();
        createTasksMigration.up();

        CreateUserTaskMigration createUserTaskMigration = new CreateUserTaskMigration();
        createUserTaskMigration.up();

        AddCurrentUserFieldInTaskTableMigration addCurrentUserFieldInTaskTableMigration = new AddCurrentUserFieldInTaskTableMigration();
        addCurrentUserFieldInTaskTableMigration.up();

        AddTotalProgressFieldInTasksTableMigration addTotalProgressFieldInTasksTableMigration = new AddTotalProgressFieldInTasksTableMigration();
        addTotalProgressFieldInTasksTableMigration.up();

        AddStartAndEndTimeInProjectTableMigration addStartAndEndTimeInProjectTableMigration = new AddStartAndEndTimeInProjectTableMigration();
        addStartAndEndTimeInProjectTableMigration.up();
    }

    public void dropMigrations() throws SQLException {
        AddStartAndEndTimeInProjectTableMigration addStartAndEndTimeInProjectTableMigration = new AddStartAndEndTimeInProjectTableMigration();
        addStartAndEndTimeInProjectTableMigration.down();

        AddTotalProgressFieldInTasksTableMigration addTotalProgressFieldInTasksTableMigration = new AddTotalProgressFieldInTasksTableMigration();
        addTotalProgressFieldInTasksTableMigration.down();     

        AddCurrentUserFieldInTaskTableMigration addCurrentUserFieldInTaskTableMigration = new AddCurrentUserFieldInTaskTableMigration();
        addCurrentUserFieldInTaskTableMigration.down();

        CreateUserTaskMigration createUserTaskMigration = new CreateUserTaskMigration();
        createUserTaskMigration.down();

        CreateTasksMigration createTasksMigration = new CreateTasksMigration();
        createTasksMigration.down();

        CreateProjectMigration createProjectMigration = new CreateProjectMigration();
        createProjectMigration.down();

        CreateUserMigration createUserMigration = new CreateUserMigration();
        createUserMigration.down();
    }
}
