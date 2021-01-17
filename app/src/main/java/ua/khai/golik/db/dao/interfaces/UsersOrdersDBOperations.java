package ua.khai.golik.db.dao.interfaces;

import java.util.ArrayList;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.entities.Order;

public interface UsersOrdersDBOperations {

    ArrayList<Order> getOrdersByUserID(DBHelper dbHelper, int id);
}
