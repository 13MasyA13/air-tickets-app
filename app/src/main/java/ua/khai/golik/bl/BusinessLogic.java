package ua.khai.golik.bl;

import java.util.Date;

import ua.khai.golik.bl.interfaces.CountFinalOrderPrice;
import ua.khai.golik.entities.Order;

public class BusinessLogic implements CountFinalOrderPrice{

    // TODO price formula

    // Price formula -> PRICE = (((DAYS * PLACE) * ADULT_COEFF + (DAYS * PLACE) * CHILDREN_COEFF) * CLASS_COEFF) * CITY_COEFF)


    // Coefficients for formula



    // Type of passengers coefficients

    private static final double CHILDREN_COEFF = 0.5;
    private static final double ADULT_COEFF = 1;

    // City coefficients

    private static final double KHARKIV_KOEFF = 1.3;
    private static final double ODESSA_KOEFF = 1.2;
    private static final double KIEV_KOEFF = 1;

    // Class of places coefficients

    private static final double BUSINESS_CLASS_KOEFF = 1.6;
    private static final double ECONOM_CLASS_KOEFF = 1;

    // TODO countPrice() method

    @Override
    public double countPrice(Order order){

        return 0;
    }

    // TODO countDays() method

    @Override
    public int countDays(Date firstDate, Date secondDate) {
        final int CONST = 1000 * 60 * 60 * 24;
        return 0;
    }
}
