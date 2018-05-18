package ua.khai.golik.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.OrderDBOperations;
import ua.khai.golik.entities.Order;

public class OrderDAO implements OrderDBOperations{

    DBHelper dbHelper;

    // TODO insertNewOrder()

    @Override
    public boolean insertNewOrder(Order order) {

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        if(contentValues.size() != 0){
            return true;
        } else{
            return false;

        }
    }

    @Override
    public boolean deleteOrderByID(int id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("DELETE * FROM " + DBHelper.ORDERS_TABLE
                + " WHERE " + DBHelper.ORDER_ID + " = " + id, null);
        // TODO how to check is data have been deleted
        return true;
    }

    @Override
    public List<Order> getAllOrders() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        List<Order> listOfAllOrders = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(DBHelper.ORDERS_TABLE, null, null, null, null, null, null);

        cursor.moveToFirst();

        // TODO DB structure

        int id;
        Date firstDate;
        Date secondDate;
        String from;
        String to;
        int price;
        int countOfChildren;
        int coundOfAdults;
        int countOfSeats;

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Order order =  new Order();
            }
        } else{
            // TODO event error
        }
        return null;
    }
}
