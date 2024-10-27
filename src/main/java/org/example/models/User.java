package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User extends Model {
    public static String tableName = "users";
    private int Id;
    private String firstName;
    private String secondName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User() {

    }
    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    public static void insert(Map<String, Object> params) throws SQLException {
        Model.insert(params, tableName);
    }

    public static List<User> all() throws SQLException {
        return getCollection(Model.all(tableName));
    }

    public static User getById(int id) throws SQLException {
        return getCollection(Model.getById(id, tableName)).getFirst();
    }

    public static void delete(int id) throws SQLException {
        Model.delete(id, tableName);
    }

    private static List<User> getCollection(ResultSet data) throws SQLException {
        ArrayList<User> users = new ArrayList<>();

        while (data.next()) {
            users.add(new User(data.getString("first_name"), data.getString("second_name")));
        }

        return users;
    }
}
