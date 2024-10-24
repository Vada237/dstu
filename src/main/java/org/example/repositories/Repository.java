package org.example.repositories;

import org.example.managers.PostgresManager;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> implements IRepository<T> {
    protected final Class<T> model;

    public Repository(Class<T> model) {
        this.model = model;
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public List<T> getAll() throws SQLException, NoSuchFieldException, IllegalAccessException {
        ResultSet data = PostgresManager.executeSelect("SELECT * FROM " + this.getTableName());
        List<T> result = new ArrayList<>();

        while (data.next()) {
            result.add(new T());
        }

        return null;
    }

    @Override
    public T create(T object) {
        return null;
    }

    @Override
    public T update(T object) {
        return null;
    }

    @Override
    public void delete(T object) {

    }

    private String getTableName() throws IllegalAccessException, NoSuchFieldException {
        Field field = this.model.getField("tableName");
        field.setAccessible(true);

        return (String) field.get(null);
    }
}
