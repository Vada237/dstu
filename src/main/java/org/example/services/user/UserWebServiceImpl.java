package org.example.services.user;

import org.example.models.User;

import javax.jws.WebService;
import java.sql.SQLException;

@WebService(endpointInterface = "org.example.services.user.UserWebService")
public class UserWebServiceImpl implements UserWebService {
    @Override
    public User getUserById(int id) throws SQLException {
        return User.getById(id);
    }
}
