package ua.khai.golik.db.dao;

import java.util.List;

import ua.khai.golik.db.dao.interfaces.UserDBOperations;
import ua.khai.golik.entities.User;

public class UserDAO implements UserDBOperations{

    @Override
    public User loginUserByLogAndPass(String login, String password) {
        return null;
    }

    @Override
    public boolean insertNewUser(User user) {
        return false;
    }

    @Override
    public User getUserByID(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
