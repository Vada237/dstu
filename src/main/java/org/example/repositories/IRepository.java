package org.example.repositories;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    public List<T> getAll() throws SQLException, NoSuchFieldException, IllegalAccessException;
    public T getById(int id);
    public T create(T object);
    public T update(T object);
    public void delete(T object);
}
