package ua.khai.golik.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.UserDBOperations;
import ua.khai.golik.entities.User;

public class UserDAO implements UserDBOperations{

    DBHelper dbHelper;

    @Override
    public boolean loginUserByLogAndPass(String login, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT login, password FROM " + DBHelper.USER_TABLE
                + " WHERE login = " + login + " AND password = " + password, null);

        int logInd = cursor.getColumnIndex(DBHelper.USER_LOGIN);
        int pasInd = cursor.getColumnIndex(DBHelper.USER_PASSWORD);

        String log = cursor.getString(logInd);
        String pass = cursor.getString(pasInd);

        if(log.equals("") || log == null){
            return false;
        } else if(pass.equals("") || pass == null){
            return false;
        }

        return true;
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
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, null, null, null, null, null , null);

        cursor.moveToFirst();

        cursor.move(id);

        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.USER_ID)));
        user.setFirst_name(cursor.getString(cursor.getColumnIndex(DBHelper.USER_FIRST_NAME)));
        user.setLast_name(cursor.getString(cursor.getColumnIndex(DBHelper.USER_LAST_NAME)));
        user.setFirst_phone_number(cursor.getString(cursor.getColumnIndex(DBHelper.USER_FIRST_PHONE_NUMBER)));
        user.setSecond_phone_number(cursor.getString(cursor.getColumnIndex(DBHelper.USER_SECOND_PHONE_NUMBER)));
        user.setBirthDate(cursor.getString(cursor.getColumnIndex(DBHelper.USER_BIRTH_DATE)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(DBHelper.USER_EMAIL)));
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, null, null, null, null, null , null);

        cursor.moveToFirst();

        int idIndex = cursor.getColumnIndex(DBHelper.USER_ID);
        int firstNameIndex = cursor.getColumnIndex(DBHelper.USER_FIRST_NAME);
        int lastNameIndex = cursor.getColumnIndex(DBHelper.USER_LAST_NAME);
        int firstPhoneIndex = cursor.getColumnIndex(DBHelper.USER_FIRST_PHONE_NUMBER);
        int secondPhoneIndex = cursor.getColumnIndex(DBHelper.USER_SECOND_PHONE_NUMBER);
        int birthIndex = cursor.getColumnIndex(DBHelper.USER_BIRTH_DATE);
        int emailIndex = cursor.getColumnIndex(DBHelper.USER_EMAIL);

        List<User> userList = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                User user = new User();

                user.setId(cursor.getInt(idIndex));
                user.setFirst_name(cursor.getString(firstNameIndex));
                user.setLast_name(cursor.getString(lastNameIndex));
                user.setFirst_phone_number(cursor.getString(firstPhoneIndex));
                user.setSecond_phone_number(cursor.getString(secondPhoneIndex));
                user.setBirthDate(cursor.getString(birthIndex));
                user.setEmail(cursor.getString(emailIndex));

                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public void deleteAllData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from " + DBHelper.USER_TABLE);
    }
}
