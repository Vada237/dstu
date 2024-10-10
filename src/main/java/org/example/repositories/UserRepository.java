package org.example.repositories;

import org.example.models.User;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<Integer, User> users;

    public UserRepository() {
        this.users = new HashMap<Integer, User>();
        this.users.put(1, new User(1, "Denis", "Le"));
        this.users.put(2, new User(2, "Ivan", "Ivanov"));
        this.users.put(3, new User(3, "Alexander", "Petrov"));
        this.users.put(4, new User(4,  "Smetan", "Dubov"));
    }

    public User getById(int id) {
        return this.users.get(id);
    }
}
