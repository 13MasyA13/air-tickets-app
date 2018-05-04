package ua.khai.golik.db.interfaces;

import java.util.List;

import ua.khai.golik.entities.Order;

public interface OrderDBOperations {

    public boolean insertNewOprder(Order order);

    public Order getOrderByID(int id);

    public List<Order> getAllOrders();
}
