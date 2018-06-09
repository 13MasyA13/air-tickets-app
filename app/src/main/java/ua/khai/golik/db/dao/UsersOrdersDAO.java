package ua.khai.golik.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.interfaces.UsersOrdersDBOperations;
import ua.khai.golik.entities.Order;

public class UsersOrdersDAO implements UsersOrdersDBOperations{

    @Override
    public List<Order> getOrdersByUserID(DBHelper dbHelper, int user_id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Cursor cursor = db.query(DBHelper.ORDERS_TABLE, null, "user_id = ?", new String[]{String.valueOf(user_id)}, null, null, null);

        Cursor cursor = db.query(DBHelper.ORDERS_TABLE, null, "user_id = ?",new String[]{String.valueOf(user_id)},null,null,null,null);

        int id = cursor.getColumnIndex(DBHelper.ORDER_ID);
        int users_id = cursor.getColumnIndex(DBHelper.USER_ID_IN_ORDER);
        int firstDate = cursor.getColumnIndex(DBHelper.FIRST_DATE);
        int secondDate = cursor.getColumnIndex(DBHelper.SECOND_DATE);
        int from = cursor.getColumnIndex(DBHelper.FROM_PLACE);
        int to = cursor.getColumnIndex(DBHelper.TO_PLACE);
        int price = cursor.getColumnIndex(DBHelper.PRICE);
        int countOfChildren = cursor.getColumnIndex(DBHelper.COUNT_OF_CHILDREN);
        int countOfAdults = cursor.getColumnIndex(DBHelper.COUNT_OF_ADULTS);
        int countOfSeats = cursor.getColumnIndex(DBHelper.COUNT_OF_SEATS);

        List<Order> listOfOrders = new ArrayList<>();

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                Order order = new Order();

                order.setId(cursor.getInt(id));
                order.setUser_id(users_id);
                order.setFirst_date(cursor.getString(firstDate));
                order.setSecond_date(cursor.getString(secondDate));
                order.setFrom_place(cursor.getString(from));
                order.setTo_place(cursor.getString(to));
                order.setPrice(cursor.getInt(price));
                order.setCount_of_children(cursor.getInt(countOfChildren));
                order.setCount_of_adults(cursor.getInt(countOfAdults));
                order.setCount_of_seats(cursor.getInt(countOfSeats));

                listOfOrders.add(order);
            }
        }

        return listOfOrders;
    }
}
