package org.example.repositories;

import org.example.models.User;

public class UserRepository extends Repository<User>{
    public UserRepository() {
        super();
        this.objects.put(1, new User("Denis", "Le"));
        this.objects.put(2, new User("Ivan", "Ivanov"));
        this.objects.put(3, new User("Alexander", "Petrov"));
        this.objects.put(4, new User( "Smetan", "Dubov"));
    }
}
