package org.example.repositories;

import java.util.HashMap;

public abstract class Repository<T> {
    protected final HashMap<Integer, T> objects;

    public Repository() {
        this.objects = new HashMap<>();
    }

    public T getById(int id) {
        return this.objects.get(id);
    }
}
