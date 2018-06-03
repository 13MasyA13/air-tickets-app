package ua.khai.golik.db.dao.interfaces;

import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.entities.Order;

public interface UsersOrdersDBOperations {

    List<Order> getOrdersByUserID(DBHelper dbHelper, int id);
}
