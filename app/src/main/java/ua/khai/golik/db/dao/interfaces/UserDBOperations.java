package ua.khai.golik.db.dao.interfaces;

import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.entities.User;

public interface UserDBOperations {

    public boolean insertNewUser(DBHelper dbHelper, User user);

    public User getUserByID(DBHelper dbHelper, int id);

    public boolean loginUserByLogAndPass(DBHelper dbHelper,String login, String password);

    public void deleteAllData(DBHelper dbHelper);

    public boolean checkForUniqueLogin(DBHelper dbHelper, String login);

    public List<User> getAllUsers(DBHelper dbHelper);
}
