package ua.khai.golik.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.UserDBOperations;
import ua.khai.golik.entities.Order;
import ua.khai.golik.entities.User;
import ua.khai.golik.layoutsCreating.RegisterActivity;

public class UserDAO implements UserDBOperations{

    @Override
    public boolean loginUserByLogAndPass(DBHelper dbHelper, String login, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, new String[]{DBHelper.USER_LOGIN, DBHelper.USER_PASSWORD}, "login = ? AND password = ?",
                new String[]{login, password}, null, null, null);

        int logInd = cursor.getColumnIndex(DBHelper.USER_LOGIN);
        int pasInd = cursor.getColumnIndex(DBHelper.USER_PASSWORD);

        if(cursor.getCount() <= 0){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean insertNewUser(DBHelper dbHelper, User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        final String SQL = "INSERT INTO users ( " + DBHelper.USER_FIRST_NAME + " , " + DBHelper.USER_LAST_NAME + " , " +
                DBHelper.USER_LOGIN + " , " + DBHelper.USER_PASSWORD + " , " + DBHelper.USER_FIRST_PHONE_NUMBER + " , " +
                DBHelper.USER_SECOND_PHONE_NUMBER  + " , " + DBHelper.USER_EMAIL + " ) " +
                " VALUES ( " + "\'" + user.getFirst_name() + "\'" + " , " + "\'" + user.getLast_name() + "\'" + " , " + "\'" +
                user.getLogin() + "\'" + " , " + "\'" + user.getPassword() + "\'" + " , " + "\'" + user.getFirst_phone_number() + "\'" +
                " , " + "\'" + user.getSecond_phone_number() + "\'" +  " , " + "\'" + user.getEmail() + "\'" + ")";
        db.execSQL(SQL);

        RegisterActivity.login = user.getLogin();
        RegisterActivity.name = user.getFirst_name();

        AbstractDAOFactory factory = new SQLiteDAOFactory();
        UserDAO userDAO = factory.getUserDAO();

        int currentUsersId = userDAO.getUserIdByUserLogin(dbHelper, user.getLogin());

        Order order = new Order();

        order.setUser_id(currentUsersId);
        order.setFirst_date("00/00/0000");
        order.setSecond_date("00/00/0000");
        order.setFrom_place("XXX");
        order.setTo_place("YYY");
        order.setPrice(9999999);
        order.setCount_of_children(1);
        order.setCount_of_adults(1);
        order.setCount_of_seats(2);

        db.execSQL("INSERT INTO orders ( " + DBHelper.USER_ID_IN_ORDER + " , " + DBHelper.FIRST_DATE + " , " + DBHelper.SECOND_DATE + " , " +
                DBHelper.FROM_PLACE + " , " + DBHelper.TO_PLACE + " , " + DBHelper.PRICE + " , " +
                DBHelper.COUNT_OF_CHILDREN + " , " + DBHelper.COUNT_OF_ADULTS + " , " + DBHelper.COUNT_OF_SEATS + " ) " +
                " VALUES ( " + order.getUser_id() + " , " + "\'" + order.getFirst_date() + "\'" + " , " + "\'" + order.getSecond_date() +
                "\'" + " , " + "\'" + order.getFrom_place() + "\'" + " , " + "\'" + order.getTo_place() + "\'" + " , " + order.getPrice() +
                " , " + order.getCount_of_children()+ " , " + order.getCount_of_adults() +
                " , " + order.getCount_of_seats() + ")");

        return true;
    }

    @Override
    public User getUserByID(DBHelper dbHelper, int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, null, "id = ?", new String[]{String.valueOf(id)}, null, null , null);

        cursor.moveToFirst();

        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.USER_ID)));
        user.setFirst_name(cursor.getString(cursor.getColumnIndex(DBHelper.USER_FIRST_NAME)));
        user.setLast_name(cursor.getString(cursor.getColumnIndex(DBHelper.USER_LAST_NAME)));
        user.setFirst_phone_number(cursor.getString(cursor.getColumnIndex(DBHelper.USER_FIRST_PHONE_NUMBER)));
        user.setSecond_phone_number(cursor.getString(cursor.getColumnIndex(DBHelper.USER_SECOND_PHONE_NUMBER)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(DBHelper.USER_EMAIL)));

        return user;
    }

    @Override
    public List<User> getAllUsers(DBHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, null, null, null, null, null , null);

        cursor.moveToFirst();

        int idIndex = cursor.getColumnIndex(DBHelper.USER_ID);
        int firstNameIndex = cursor.getColumnIndex(DBHelper.USER_FIRST_NAME);
        int lastNameIndex = cursor.getColumnIndex(DBHelper.USER_LAST_NAME);
        int firstPhoneIndex = cursor.getColumnIndex(DBHelper.USER_FIRST_PHONE_NUMBER);
        int secondPhoneIndex = cursor.getColumnIndex(DBHelper.USER_SECOND_PHONE_NUMBER);
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
                user.setEmail(cursor.getString(emailIndex));

                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public boolean checkForUniqueLogin(DBHelper dbHelper, String login) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, null, null, null,null,null,null);
        ArrayList<String> allLogins = new ArrayList<>();

        int idIndex = cursor.getColumnIndex(DBHelper.USER_ID);
        int fNameIndex = cursor.getColumnIndex(DBHelper.USER_FIRST_NAME);
        int loginIndex = cursor.getColumnIndex(DBHelper.USER_LOGIN);
        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                String currentLogin = cursor.getString(loginIndex);
                allLogins.add(currentLogin);
            }
        }

        boolean answ = true;

        Iterator<String> iterator = allLogins.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(login)) {
                answ = false;
            } else {
                answ = true;
                break;
            }
        }

        return answ;
    }

    @Override
    public int getUserIdByUserLogin(DBHelper dbHelper, String login) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.USER_TABLE, new String[]{DBHelper.USER_ID}, "login = ?", new String[]{login}, null, null, null);

        int idIndex = cursor.getColumnIndex(DBHelper.USER_ID);

        cursor.moveToFirst();

        int answ = cursor.getInt(idIndex);

        return answ;
    }

    @Override
    public void deleteAllData(DBHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from " + DBHelper.USER_TABLE);
    }
}
