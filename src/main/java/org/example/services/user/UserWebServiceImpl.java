package org.example.services.user;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.services.user.UserWebService;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.services.user.UserWebService")
public class UserWebServiceImpl implements UserWebService {
    private final UserRepository userRepository = new UserRepository();

    @Override
    public User getUserById(int id) {
        return this.userRepository.getById(id);
    }
}
