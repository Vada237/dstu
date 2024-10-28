package org.example.services.user;

import org.example.models.User;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.Map;

@WebService(endpointInterface = "org.example.services.user.UserWebService")
public class UserWebServiceImpl implements UserWebService {
    @Override
    public User getUserById(int id) throws SQLException {
        return User.getById(id);
    }

    @Override
    public void createUser(User user) throws SQLException {
        User.insert(Map.ofEntries(
                Map.entry("first_name", user.getFirstName()),
                Map.entry("second_name", user.getSecondName())
        ));
    }

    @Override
    public void deleteUserById(int id) throws SQLException {
        User.deleteById(id);
    }

    @Override
    public User[] getByFirstAndSecondName(String firstName, String secondName) throws SQLException {
        return User.getByFirstAndSecondName(firstName, secondName).toArray(new User[0]);
    }
}
