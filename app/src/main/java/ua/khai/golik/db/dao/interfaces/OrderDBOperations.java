package ua.khai.golik.db.dao.interfaces;

import java.util.List;

import ua.khai.golik.db.DBHelper;
import ua.khai.golik.entities.Order;

public interface OrderDBOperations {

    public boolean insertNewOrder(DBHelper dbHelper, Order order, int id);

    public void deleteOrderByID(DBHelper dbHelper, int id);

    public void deleteAllData(DBHelper dbHelper);

    public List<Order> getAllOrders(DBHelper dbHelper);
}
