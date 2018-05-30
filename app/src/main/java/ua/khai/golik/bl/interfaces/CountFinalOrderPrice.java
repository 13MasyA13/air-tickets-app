package ua.khai.golik.bl.interfaces;

import ua.khai.golik.entities.Order;

public interface CountFinalOrderPrice {

    double countPrice(Order order);

    long countDays(int[] firstDateMas, int[] secondDateMas);

    boolean classOfSeats(String classOfSeats);

    int[] regexStringToDataMass(String data);

    double countPriceForToPlace(String toPlace);

    double countPlacePrice(String place);
}
