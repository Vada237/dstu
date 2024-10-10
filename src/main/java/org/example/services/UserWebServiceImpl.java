package org.example.services;

import jakarta.inject.Inject;
import org.example.models.User;
import org.example.repositories.UserRepository;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.services.UserWebService")
public class UserWebServiceImpl implements UserWebService{
    private final UserRepository userRepository = new UserRepository();

    @Override
    public User getUserById(int id) {
        return this.userRepository.getById(id);
    }
}
