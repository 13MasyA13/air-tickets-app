package ua.khai.golik.db.dao;

import java.util.List;

import ua.khai.golik.db.dao.interfaces.OrderDBOperations;
import ua.khai.golik.entities.Order;

public class OrderDAO implements OrderDBOperations{

    @Override
    public boolean insertNewOrder(Order order) {
        return false;
    }

    @Override
    public Order getOrderByID(int id) {
        return null;
    }

    @Override
    public boolean deleteOrderByID(int id) {
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }
}
