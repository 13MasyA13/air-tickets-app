package ua.khai.golik.bl;

import java.util.Calendar;

import ua.khai.golik.bl.interfaces.CountFinalOrderPrice;
import ua.khai.golik.entities.Order;

public class BusinessLogic implements CountFinalOrderPrice{

    // Price formula -> PRICE = CHILDREN_PRICE + ADULTS_PRICE

    // CHILDREN_PRICE = DEF_PRICE * DAYS * CITY_COEFF * CLASS_OF_PLACES_COEFF * CHILDREN_COUNT * CHILDREN_COEFF
    // ADULTS_PRICE = DEF_PRICE * DAYS * CITY_COEFF * CLASS_OF_PLACES_COEFF * ADULTS_COUNT * ADULTS_COEFF


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

    // Default prices
    
    private static final double sharmPrice = 250;
    private static final double kemerPrice = 120;
    private static final double antalyaPrice = 215;
    private static final double kairoPrice = 119;
    private static final double mentonPrice = 280;
    private static final double nerjaPrice = 375;
    private static final double biarritzPrice = 590;
    private static final double sanSebastianPrice = 1250;
    private static final double formentaraPrice = 950;
    private static final double portoSantoPrice = 1090;
    private static final double viareggioPrice = 470;
    private static final double playaBlancaPrice = 940;

    // TODO countPrice() method

    @Override
    public double countPrice(Order order){
        double answ = 0;

        // TODO fucking regex

        //long countOfDays = countDays();
        double defPrice = 0;

        double adults_price, children_price = 0;


        return answ;
    }

    @Override
    public long countDays(int[] firstDateMas, int[] secondDateMas) {
        long answer, answerMilliSeconds = 0;

        Calendar firstDate = Calendar.getInstance();
        firstDate.set(firstDateMas[2], firstDateMas[1], firstDateMas[0]);

        Calendar secondDate = Calendar.getInstance();
        secondDate.set(secondDateMas[2], secondDateMas[1], secondDateMas[0]);

        long d1 = firstDate.getTimeInMillis();
        long d2 = secondDate.getTimeInMillis();

        answerMilliSeconds = d2 - d1;

        answer = answerMilliSeconds * 1000 * 60 * 60 * 24;

        return answer;
    }

    @Override
    public boolean classOfSeats(String classOfSeats) {
        return false;
    }

    @Override
    public int[] regexStringToDataMass(String data) {
        return new int[0];
    }

    @Override
    public double countPriceForToPlace(String toPlace) {
        return 0;
    }

    @Override
    public double countPlacePrice(String place) {
        return 0;
    }
}
