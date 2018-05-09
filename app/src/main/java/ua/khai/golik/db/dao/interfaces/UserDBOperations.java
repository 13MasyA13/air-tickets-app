package ua.khai.golik.db.dao.interfaces;

import java.util.List;

import ua.khai.golik.entities.User;

public interface UserDBOperations {

    public boolean insertNewUser(User user);

    public User getUserByID(int id);

    public List<User> getAllUsers();
}
