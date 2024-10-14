package org.example.repositories;

import org.example.models.User;

public class UserRepository extends Repository<User>{
    public UserRepository() {
        super();
        this.objects.put(1, new User(1, "Denis", "Le"));
        this.objects.put(2, new User(2, "Ivan", "Ivanov"));
        this.objects.put(3, new User(3, "Alexander", "Petrov"));
        this.objects.put(4, new User(4,  "Smetan", "Dubov"));
    }
}
