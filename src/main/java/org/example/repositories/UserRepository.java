package org.example.repositories;

import org.example.models.User;

public class UserRepository extends Repository<User>{
    public UserRepository() {
        super(User.class);
    }
}
