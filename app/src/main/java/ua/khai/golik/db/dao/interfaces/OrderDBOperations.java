package ua.khai.golik.db.dao.interfaces;

import java.util.List;

import ua.khai.golik.entities.Order;

public interface OrderDBOperations {

    public boolean insertNewOrder(Order order);

    public boolean deleteOrderByID(int id);

    public void deleteAllData();

    public List<Order> getAllOrders();
}
