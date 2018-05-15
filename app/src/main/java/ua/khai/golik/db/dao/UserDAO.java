package ua.khai.golik.db.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.UserDBOperations;
import ua.khai.golik.entities.User;

// TODO UserDBOperations

public class UserDAO implements UserDBOperations{

    DBHelper dbHelper;

    @Override
    public boolean loginUserByLogAndPass(String login, String password) {
        return false;
    }

    @Override
    public boolean insertNewUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.USER_FIRST_NAME, user.getFirst_name());
        contentValues.put(DBHelper.USER_LAST_NAME, user.getLast_name());
        contentValues.put(DBHelper.USER_LOGIN, user.getLogin());
        contentValues.put(DBHelper.USER_PASSWORD, user.getPassword());
        contentValues.put(DBHelper.USER_FIRST_PHONE_NUMBER, user.getFirst_phone_number());
        contentValues.put(DBHelper.USER_SECOND_PHONE_NUMBER, user.getSecond_phone_number());
        contentValues.put(DBHelper.USER_BIRTH_DATE, user.getBirthDate());
        contentValues.put(DBHelper.USER_EMAIL, user.getEmail());

        long res = db.insert(DBHelper.USER_TABLE, null, contentValues);

        if(res > 0){
            return true;
        } else {
            return false;
        }
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
