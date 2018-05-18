package ua.khai.golik.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.UsersOrdersDBOperations;
import ua.khai.golik.entities.Order;

public class UsersOrdersDAO implements UsersOrdersDBOperations{

    DBHelper dbHelper;

    @Override
    public List<Order> getOrdersByUserID(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // TODO SQL_Join between orders & users_orders tables

        Cursor cursor = db.rawQuery("SELECT * FROM orders WHERE user_id = 1", null);
        return null;
    }
}
