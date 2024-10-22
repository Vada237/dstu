package org.example.services;

import org.example.repositories.Repository;

public class ServicesImpl<T> implements Services<T>{
    private final Repository<T> repository;

    public ServicesImpl(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T getById(int id) {
        return this.repository.getById(id);
    }
}
