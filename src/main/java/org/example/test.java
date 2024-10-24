package org.example;

import org.example.repositories.UserRepository;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, IllegalAccessException {
        UserRepository repository = new UserRepository();
        System.out.println(repository.getAll());
    }
}
