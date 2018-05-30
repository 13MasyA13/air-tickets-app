package ua.khai.golik.bl.interfaces;

import ua.khai.golik.entities.Order;

public interface CountFinalOrderPrice {

    double countPrice(Order order);

    long countDays(Order order);

    double classOfSeats(Order order);

    double countPriceForToPlace(Order order);

    double countPriceForFromPlace(Order order);

}
