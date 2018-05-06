package ua.khai.golik.bl;

import ua.khai.golik.bl.interfaces.CountFinalOrderPrice;
import ua.khai.golik.entities.Order;

public class BusinessLogic implements CountFinalOrderPrice{

    // TODO price formula

    // Price formula -> (() * ADULT_COEFF + () * CHILDREN_COEFF) * CLASS_COEFF

    // Coefficients for formula

    private static final double CHILDREN_COEFF = 0.5;
    private static final double ADULT_COEFF = 1;
    private static final double KHARKIV_KOEFF = 1.3;
    private static final double KIEV_KOEFF = 1;
    private static final double BUSINESS_CLASS_KOEFF = 1.6;
    private static final double ECONOM_CLASS_KOEFF = 1;

    // TODO countPrice method

    public double countPrice(Order order){

        return 0;
    }
}
