package ua.khai.golik.bl.interfaces;

import java.util.Date;

import ua.khai.golik.entities.Order;

public interface CountFinalOrderPrice {

    double countPrice(Order order);

    int countDays(Date firstDate, Date secondDate);
}
