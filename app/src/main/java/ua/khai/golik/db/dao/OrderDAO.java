package ua.khai.golik.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.OrderDBOperations;
import ua.khai.golik.entities.Order;

public class OrderDAO implements OrderDBOperations{

    @Override
    public boolean insertNewOrder(DBHelper dbHelper, Order order) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        final String SQL = "INSERT INTO orders ( " + DBHelper.FIRST_DATE + " , " + DBHelper.SECOND_DATE + " , " +
                DBHelper.FROM_PLACE + " , " + DBHelper.TO_PLACE + " , " + DBHelper.PRICE + " , " +
                DBHelper.COUNT_OF_CHILDREN + " , " + DBHelper.COUNT_OF_ADULTS + " , " + DBHelper.COUNT_OF_SEATS + " ) " +
                " VALUES ( " + "\'" + order.getFirst_date() + "\'" + " , " + "\'" + order.getSecond_date() + "\'" + " , " + "\'" +
                order.getFrom_place() + "\'" + " , " + "\'" + order.getTo_place() + "\'" + " , " + "\'" + order.getPrice() + "\'" +
                " , " + "\'" + order.getCount_of_children() + "\'" + " , " + "\'" + order.getCount_of_adults() + "\'" + " , " + "\'" + order.getCount_of_seats() + "\'" + ")";
        db.execSQL(SQL);
        return true;
    }

    @Override
    public void deleteOrderByID(DBHelper dbHelper, int id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE * FROM " + DBHelper.ORDERS_TABLE
                + " WHERE " + DBHelper.ORDER_ID + " = " + id, null);
    }

    @Override
    public List<Order> getAllOrders(DBHelper dbHelper) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        List<Order> listOfAllOrders = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(DBHelper.ORDERS_TABLE, null, null, null, null, null, null);

        cursor.moveToFirst();

        int id = cursor.getColumnIndex(DBHelper.ORDER_ID);
        int firstDate = cursor.getColumnIndex(DBHelper.FIRST_DATE);
        int secondDate = cursor.getColumnIndex(DBHelper.SECOND_DATE);
        int from = cursor.getColumnIndex(DBHelper.FROM_PLACE);
        int to = cursor.getColumnIndex(DBHelper.TO_PLACE);
        int price = cursor.getColumnIndex(DBHelper.PRICE);
        int countOfChildren = cursor.getColumnIndex(DBHelper.COUNT_OF_CHILDREN);
        int countOfAdults = cursor.getColumnIndex(DBHelper.COUNT_OF_ADULTS);
        int countOfSeats = cursor.getColumnIndex(DBHelper.COUNT_OF_SEATS);

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Order order =  new Order();

                order.setId(cursor.getInt(id));
                order.setFirst_date(cursor.getString(firstDate));
                order.setSecond_date(cursor.getString(secondDate));
                order.setFrom_place(cursor.getString(from));
                order.setTo_place(cursor.getString(to));
                order.setPrice(cursor.getInt(price));
                order.setCount_of_children(cursor.getInt(countOfChildren));
                order.setCount_of_adults(cursor.getInt(countOfAdults));
                order.setCount_of_seats(cursor.getInt(countOfSeats));

                listOfAllOrders.add(order);
            }
        }

        return listOfAllOrders;
    }

    @Override
    public void deleteAllData(DBHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from " + DBHelper.ORDERS_TABLE);
    }
}
