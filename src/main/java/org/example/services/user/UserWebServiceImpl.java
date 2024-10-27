package org.example.services.user;

import org.example.models.User;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.services.user.UserWebService")
public class UserWebServiceImpl implements UserWebService {
    @Override
    public User getUserById(int id) {
        return new User();
    }
}
